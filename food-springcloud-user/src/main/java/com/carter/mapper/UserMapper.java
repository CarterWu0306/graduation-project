package com.carter.mapper;

import com.carter.pojo.User;
import com.carter.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    Map<String, Object> selUserInfoByName(@Param("username") String username);

    List<Map<String, Object>> sumNewUser();

    List<Map<String, Object>> getUserList(@Param("realName") String realName,@Param("userPhone") String userPhone,@Param("userType") String userType);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}