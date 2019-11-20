package com.carter.service.impl;

import com.carter.common.ResponseBo;
import com.carter.pojo.User;
import com.carter.service.LoginService;
import com.carter.service.UserService;
import com.carter.utils.JWTUtil;
import com.carter.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userServiceImpl;

    @Override
    public ResponseBo login(User user) {
        try {
            User selUser = userServiceImpl.selUser(user.getUsername());
            if(selUser!=null&&selUser.getPassword().equals(user.getPassword())){
                //生成token
                String token = JWTUtil.generateToken(user.getUsername());

                //数据放入redis
                int index = redisUtil.hmSet(token, "token", token);
                index += redisUtil.hmSet(token, "username", user.getUsername());

                //设置token的过期时间
                index += redisUtil.expire(token, JWTUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

                Map<String,String> map = new HashMap<>();
                map.put("token",token);

                //修改用户最后登录时间
                selUser.setLastLoginTime(new Date());
                index += userServiceImpl.updUser(selUser,-1);

                if (index>3){
                    return ResponseBo.success(200,"登录成功",map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBo.error(500,"登录失败,用户名或密码错误");
    }

    @Override
    public ResponseBo logout(String token) {
        if (StringUtils.isBlank(token)){
            return ResponseBo.success(200,"注销成功","");
        }
        try {
            int index = redisUtil.remove(token);
            if (index>0){
                return ResponseBo.success(200,"注销成功","");
            }else{
                return ResponseBo.success(200,"token已失效,注销成功","");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBo.error(500,"注销失败,可能原因:服务器繁忙!!!");
    }
}
