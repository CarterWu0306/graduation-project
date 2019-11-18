package com.carter.service;

import com.carter.common.ResponseBo;
import com.carter.pojo.User;

public interface LoginService {
    ResponseBo login(User user);

    ResponseBo logout(String token);
}
