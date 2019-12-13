package com.carter.mapper;

import com.carter.pojo.FlashSale;
import com.carter.pojo.FlashSaleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlashSaleMapper {
    int countByExample(FlashSaleExample example);

    int deleteByExample(FlashSaleExample example);

    int deleteByPrimaryKey(Integer flashSaleId);

    int insert(FlashSale record);

    int insertSelective(FlashSale record);

    List<FlashSale> selectByExample(FlashSaleExample example);

    FlashSale selectByPrimaryKey(Integer flashSaleId);

    int updateByExampleSelective(@Param("record") FlashSale record, @Param("example") FlashSaleExample example);

    int updateByExample(@Param("record") FlashSale record, @Param("example") FlashSaleExample example);

    int updateByPrimaryKeySelective(FlashSale record);

    int updateByPrimaryKey(FlashSale record);
}