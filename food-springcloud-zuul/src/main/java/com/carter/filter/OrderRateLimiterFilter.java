package com.carter.filter;

import com.alibaba.fastjson.JSON;
import com.carter.common.ResponseBo;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 用户移动端下单限流
 *其它和上面都一样，只是run()中逻辑不一样
 */
@Component
public class OrderRateLimiterFilter extends ZuulFilter {


    //每秒产生100个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //只对用户移动端下单接口限流
        if ("/food-feign/placeOrder/placeOrderByUser".equalsIgnoreCase(request.getRequestURI())) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();

        //就相当于每调用一次tryAcquire()方法，令牌数量减1，当100个用完后，那么后面进来的用户无法访问上面接口
        //当然这里只写类上面一个接口，可以这么写，实际可以在这里要加一层接口判断。
        if (!RATE_LIMITER.tryAcquire()) {
            requestContext.setSendZuulResponse(false);
            //HttpStatus.TOO_MANY_REQUESTS.value()里面有静态代码常量
            requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            //重中之重，这里一定要加要给Response设置CharacterEncoding编码为UTF-8
            requestContext.getResponse().setCharacterEncoding("UTF-8");
            requestContext.getResponse().setContentType("application/json;charset=UTF-8");
            //设置响应体内容
            String body = JSON.toJSONString(ResponseBo.error(HttpStatus.TOO_MANY_REQUESTS.value(),"当前访问人数过多,请稍后重试"));
            requestContext.setResponseBody(body);
        }
        return null;
    }
}