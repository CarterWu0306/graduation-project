package com.carter.controller;

import com.carter.common.ResponseBo;
import com.carter.pojo.User;
import com.carter.service.ImageService;
import com.carter.service.UserService;
import com.carter.utils.JWTUtil;
import com.carter.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private ImageService imageServiceImpl;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseBo addUser(User user, @RequestParam(value = "userType") String userType){
        try {
            //检查用户是否存在
            User checkUser = userServiceImpl.selUser(user.getUsername());
            if (checkUser==null){
                //密码加密
                user.setPassword(MD5Util.encrypByMd5(user.getPassword()));
                int index = userServiceImpl.addUser(user,userType);

                if (index>1){
                    return ResponseBo.success(200,"新增用户成功","");
                }
            }else{
                return ResponseBo.error(200,"用户名已存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBo.error(500,"新增用户失败");
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ResponseBo selUserInfoByName(@RequestHeader(value = "X-token") String token){
        try {
            //判断token是否过期
            //获取token中username
            String username = JWTUtil.getUsername(token);
            Map<String, Object> userInfo = userServiceImpl.selUserInfoByName(username);
            return ResponseBo.success(200,"拉取用户信息成功",userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBo.error(500,"拉取用户信息失败");
    }

    @RequestMapping(value = "/uploadUserImage",method = RequestMethod.POST)
    public ResponseBo uploadUserImage(@RequestParam(value = "file") MultipartFile mfile){
        try {
            String uploadResult = imageServiceImpl.uploadImage(mfile,"http://images.wukate.com/defaultUser.jpg");
            if (uploadResult!="http://images.wukate.com/defaultUser.jpg"){
                return ResponseBo.success(200,"上传成功",uploadResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseBo.error(500,"上传失败");
    }
}
