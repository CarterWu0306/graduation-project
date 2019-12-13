package com.carter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carter.common.ResponseBo;
import com.carter.pojo.User;
import com.carter.service.ImageService;
import com.carter.service.UserService;
import com.carter.utils.JWTUtil;
import com.carter.utils.MD5Util;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private ImageService imageServiceImpl;

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public ResponseBo getUserList(int page, int limit, @RequestParam Map<String, Object> map){
        try {
            PageInfo<Map<String, Object>> pi = userServiceImpl.getUserList(page, limit, map);
            return ResponseBo.list(200,"查询用户列表成功",pi.getTotal(),pi.getList());
        } catch (Exception e) {
            return ResponseBo.list(500,"查询用户列表失败",0,null);
        }
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseBo addUser(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userType = (Integer)jsonObject.get("userType");
        User user = JSONObject.parseObject(data, User.class);
        if (StringUtils.isBlank(user.getAvatar())){
            user.setAvatar("http://images.wukate.com/defaultUser.jpg");
        }
        try {
            //检查用户是否存在
            User checkUser = userServiceImpl.selUser(user.getUsername());
            if (checkUser==null){
                //密码加密
                user.setPassword(MD5Util.encrypByMd5(user.getPassword()));
                int index = userServiceImpl.addUser(user,userType);
                return ResponseBo.success(200,"新增用户成功","");
            }else{
                return ResponseBo.error(200,"用户名已存在");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"新增用户失败");
        }
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public ResponseBo updateUser(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userType = (Integer)jsonObject.get("userType");
        User user = JSONObject.parseObject(data, User.class);
        if (StringUtils.isBlank(user.getAvatar())){
            user.setAvatar("http://images.wukate.com/defaultUser.jpg");
        }
        try {
            //检查用户是否存在
            User oldUser = userServiceImpl.selUserById(user.getUserId());
            User checkUser = userServiceImpl.selUser(user.getUsername());
            if (checkUser==null || oldUser.getUsername().equals(user.getUsername())){
                userServiceImpl.updUser(user,userType);
                return ResponseBo.success(200,"修改用户成功","");
            }else{
                return ResponseBo.error(200,"用户名已存在");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"修改用户失败");
        }
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ResponseBo deleteUser(Integer userId){
        try {
            userServiceImpl.delUser(userId);
            return ResponseBo.success(200,"删除用户成功","");
        } catch (Exception e) {
            return ResponseBo.success(500,"删除用户失败","");
        }
    }

    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    public ResponseBo changePwd(@RequestBody User user){
        try {
            //密码加密
            user.setPassword(MD5Util.encrypByMd5(user.getPassword()));
            userServiceImpl.changePwd(user);
            return ResponseBo.success(200,"修改密码成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"修改密码失败");
        }
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ResponseBo selUserInfoByName(@RequestHeader(value = "X-token") String token){
        try {
            //获取token中username
            String username = JWTUtil.getUsername(token);
            Map<String, Object> userInfo = userServiceImpl.selUserInfoByName(username);
            return ResponseBo.success(200,"拉取用户信息成功",userInfo);
        } catch (Exception e) {
            return ResponseBo.error(500,"拉取用户信息失败");
        }
    }

    @RequestMapping(value = "/uploadUserImage",method = RequestMethod.POST)
    public ResponseBo uploadUserImage(@RequestParam(value = "file") MultipartFile mfile){
        try {
            String uploadResult = imageServiceImpl.uploadImage(mfile,"http://images.wukate.com/defaultUser.jpg");
            if (uploadResult!="http://images.wukate.com/defaultUser.jpg"){
                return ResponseBo.success(200,"上传成功",uploadResult);
            }
        } catch (IOException e) {
            return ResponseBo.error(500,"上传失败");
        }
        return ResponseBo.error(500,"上传失败");
    }

    @RequestMapping(value = "/addUserScore",method = RequestMethod.POST)
    public int addUserScore(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = (Integer)jsonObject.get("userId");
        String realTotalMoney = (String)jsonObject.get("realTotalMoney");
        int score = (Double.valueOf(realTotalMoney).intValue());
        return userServiceImpl.addUserScore(userId, score);
    }

    @RequestMapping(value = "/decreaseUserScore",method = RequestMethod.POST)
    public int decreaseUserScore(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = (Integer)jsonObject.get("userId");
        Integer deductionScore = (Integer)jsonObject.get("deductionScore");
        return userServiceImpl.decreaseUserScore(userId, deductionScore);
    }

    @RequestMapping(value = "/sumNewUser",method = RequestMethod.GET)
    public ResponseBo sumNewUser(){
        try {
            List<Map<String, Object>> data = userServiceImpl.sumNewUser();
            return ResponseBo.success(200,"统计新增用户成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计新增用户失败");
        }
    }
}
