package com.carter.controller;

import com.carter.common.ResponseBo;
import com.carter.pojo.User;
import com.carter.service.LoginService;
import com.carter.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginServiceImpl;

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public ResponseBo login(@RequestBody User user) {
        user.setPassword(MD5Util.encrypByMd5(user.getPassword()));
        return loginServiceImpl.login(user);
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.POST)
    public ResponseBo logout(@RequestHeader(value = "X-token") String token){
        return loginServiceImpl.logout(token);
    }
}
