package com.carter.filter;

import com.alibaba.fastjson.JSON;
import com.carter.common.ResponseBo;
import com.carter.utils.JWTUtil;
import com.carter.utils.RedisUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.concurrent.TimeUnit;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 登录过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 过滤器类型
     * 前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器顺序，越小越先执行
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否生效
     * 返回true代表需要权限校验，false代表不需要用户校验即可访问
     */
    @Override
    public boolean shouldFilter() {
        //共享RequestContext，上下文对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println(request.getRequestURI());
        //不需要权限校验URL
        if ("/food-user/user/login".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/food-user/user/logout".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/food-goods/goods/selAllGoodsList".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/food-goods/goods/selGoodsLabel".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/food-evaluation/evaluation/sumEvaluation".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        } else if ("/food-evaluation/evaluation/getAllEvaluationByParam".equalsIgnoreCase(request.getRequestURI())) {
            return false;
        }
        return true;
    }

    /**
     * 业务逻辑
     * 只有上面返回true的时候，才会进入到该方法
     */
    @Override
    public Object run() throws ZuulException {
        //JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //token对象,有可能在请求头传递过来，也有可能是通过参数传过来，实际开发一般都是请求头方式
        String token = request.getHeader("X-token");

        /*if (StringUtils.isBlank((token))) {
            token = request.getParameter("X-token");
        }*/
        System.out.println("页面传来的token值为：" + token);
        //登录校验逻辑  如果token为null,则直接返回客户端，而不进行下一步接口调用
        if (StringUtils.isBlank(token)) {
            // 过滤该请求，不对其进行路由
            requestContext.setSendZuulResponse(false);
            //返回错误代码
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            //重中之重，这里一定要加要给Response设置CharacterEncoding编码为UTF-8
            requestContext.getResponse().setCharacterEncoding("UTF-8");
            requestContext.getResponse().setContentType("application/json;charset=UTF-8");
            //设置响应体内容
            String body = JSON.toJSONString(ResponseBo.error(401,"登录信息不存在或已失效,请重新登录"));
            requestContext.setResponseBody(body);
        }else{
            //从Redis校验token是否有效
            //如果token过期
            if (stringRedisTemplate.getExpire(token)<=0){
                System.out.println("token过期");
                // 过滤该请求，不对其进行路由
                requestContext.setSendZuulResponse(false);
                //返回错误代码
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                //重中之重，这里一定要加要给Response设置CharacterEncoding编码为UTF-8
                requestContext.getResponse().setCharacterEncoding("UTF-8");
                requestContext.getResponse().setContentType("application/json;charset=UTF-8");
                //设置响应体内容
                String body = JSON.toJSONString(ResponseBo.error(401,"登录信息已失效,请重新登录"));
                requestContext.setResponseBody(body);
            }else{
                //如果token有效,刷新token有效时间
                redisUtil.expire(token, JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
            }
        }
        return null;
    }
}
