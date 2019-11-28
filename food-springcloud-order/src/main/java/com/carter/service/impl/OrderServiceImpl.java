package com.carter.service.impl;

import com.carter.mapper.OrderGoodsMapper;
import com.carter.mapper.TheOrderMapper;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.carter.service.OrderService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public PageInfo<Map<String, Object>> getOrderListByParam(int page, int limit, String orderSn, String tabType, String startDate) {
        PageHelper.startPage(page,limit);

        List<Map<String, Object>> maps = theOrderMapper.selOrderList(orderSn, tabType, startDate);

        //分页代码
        //设置分页条件
        PageInfo<Map<String, Object>> pi = new PageInfo<Map<String, Object>>(maps);
        return pi;
    }

    @Override
    public List<Map<String, Object>> getAllOrders() {
        List<Map<String, Object>> maps = theOrderMapper.selOrderList("", "", "");
        return maps;
    }
}
