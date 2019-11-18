package com.carter.service.impl;

import com.carter.mapper.UserMapper;
import com.carter.mapper.UserRoleMapper;
import com.carter.pojo.User;
import com.carter.pojo.UserExample;
import com.carter.pojo.UserRole;
import com.carter.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User selUser(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size()>0){
            return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public int addUser(User user, String userType) {
        int index = userMapper.insertSelective(user);
        //新增用户-角色关系
        UserRole userRole = new UserRole();
        userRole.setRoleId(Integer.parseInt(userType));
        userRole.setUserId(user.getUserId());
        index += userRoleMapper.insertSelective(userRole);
        return index;
    }

    @Override
    public int updUser(User user) {
        int index = userMapper.updateByPrimaryKeySelective(user);
        return index;
    }

    @Override
    public Map<String, Object> selUserInfoByName(String username) {
        Map<String, Object> userInfo = userMapper.selUserInfoByName(username);
        return userInfo;
    }
}
