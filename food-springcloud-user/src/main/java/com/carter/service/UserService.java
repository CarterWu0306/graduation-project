package com.carter.service;

import com.carter.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService {
    User selUser(String username);

    User selUserById(Integer userId);

    PageInfo<Map<String, Object>> getUserList(int page, int limit, Map<String, Object> map);

    int addUser(User user, Integer userType);

    int updUser(User user, Integer userType);

    int delUser(Integer userId);

    int changePwd(User user);

    Map<String, Object> selUserInfoByName(String username);

    int addUserScore(Integer userId,Integer score);
}
