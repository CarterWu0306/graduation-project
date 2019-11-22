package com.carter.mapper;

import com.carter.pojo.OrderGoods;
import com.carter.pojo.OrderGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    int countByExample(OrderGoodsExample example);

    int deleteByExample(OrderGoodsExample example);

    int deleteByPrimaryKey(Integer orderGoodsId);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    List<OrderGoods> selectByExample(OrderGoodsExample example);

    OrderGoods selectByPrimaryKey(Integer orderGoodsId);

    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}