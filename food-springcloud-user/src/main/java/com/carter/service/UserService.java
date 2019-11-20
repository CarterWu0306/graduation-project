package com.carter.service;

import com.carter.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface UserService {
    User selUser(String username);

    PageInfo<Map<String, Object>> getUserList(int page, int limit, Map<String, Object> map);

    int addUser(User user, String userType);

    int updUser(User user);

    Map<String, Object> selUserInfoByName(String username);
}
