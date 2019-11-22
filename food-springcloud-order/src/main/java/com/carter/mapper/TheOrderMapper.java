package com.carter.mapper;

import com.carter.pojo.TheOrder;
import com.carter.pojo.TheOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TheOrderMapper {
    int countByExample(TheOrderExample example);

    int deleteByExample(TheOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(TheOrder record);

    int insertSelective(TheOrder record);

    List<TheOrder> selectByExample(TheOrderExample example);

    TheOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") TheOrder record, @Param("example") TheOrderExample example);

    int updateByExample(@Param("record") TheOrder record, @Param("example") TheOrderExample example);

    int updateByPrimaryKeySelective(TheOrder record);

    int updateByPrimaryKey(TheOrder record);
}