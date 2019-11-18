package com.carter.service;

import com.carter.pojo.User;

import java.util.Map;

public interface UserService {
    User selUser(String username);

    int addUser(User user, String userType);

    int updUser(User user);

    Map<String, Object> selUserInfoByName(String username);
}
