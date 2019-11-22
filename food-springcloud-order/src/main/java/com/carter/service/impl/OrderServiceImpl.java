package com.carter.service.impl;

import com.carter.mapper.OrderGoodsMapper;
import com.carter.mapper.TheOrderMapper;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.carter.service.OrderService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private TheOrderMapper theOrderMapper;
    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int addOrderByAdmin(TheOrder theOrder, List<OrderGoods> goodsList) {
        int index = theOrderMapper.insertSelective(theOrder);

        //新增订单-商品表
        for (OrderGoods goods:goodsList){
            goods.setOrderId(theOrder.getOrderId());
            index += orderGoodsMapper.insertSelective(goods);
        }
        return index;
    }
}
