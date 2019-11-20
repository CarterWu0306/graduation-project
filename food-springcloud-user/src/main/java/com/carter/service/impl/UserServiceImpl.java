package com.carter.service.impl;

import com.carter.mapper.UserMapper;
import com.carter.mapper.UserRoleMapper;
import com.carter.pojo.User;
import com.carter.pojo.UserExample;
import com.carter.pojo.UserRole;
import com.carter.service.UserService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
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
    public PageInfo<Map<String, Object>> getUserList(int page, int limit, Map<String, Object> map) {
        PageHelper.startPage(page,limit);

        String realName = (String)map.get("realName");
        String userPhone = (String)map.get("userPhone");
        String userType = (String)map.get("userType");

        List<Map<String, Object>> userList = userMapper.getUserList(realName, userPhone, userType);

        //分页代码
        //设置分页条件
        PageInfo<Map<String, Object>> pi = new PageInfo<>(userList);

        return pi;
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
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
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
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
