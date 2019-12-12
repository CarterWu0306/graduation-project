package com.carter.service.impl;

import com.carter.mapper.OrderGoodsMapper;
import com.carter.mapper.TheOrderMapper;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.OrderGoodsExample;
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
    public PageInfo<Map<String, Object>> getOrderListByParam(int page, int limit, String orderSn, String tabType, String startDate) {
        PageHelper.startPage(page,limit);

        List<Map<String, Object>> list = theOrderMapper.selOrderList(orderSn, tabType, startDate);

        //分页代码
        //设置分页条件
        PageInfo<Map<String, Object>> pi = new PageInfo<Map<String, Object>>(list);
        return pi;
    }

    @Override
    public List<Map<String, Object>> getAllOrders() {
        List<Map<String, Object>> maps = theOrderMapper.selOrderList("", "", "");
        return maps;
    }

    @Override
    public List<Map<String, Object>> getOrdersByParam(Integer userId, String tabType) {
        List<Map<String, Object>> list = theOrderMapper.selOrderListByUser(userId,tabType);
        return list;
    }

    @Override
    public TheOrder getOrderByOrderId(Integer orderId) {
        return theOrderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int changeOrderStatus(TheOrder order) {
        return theOrderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int deleteOrder(Integer orderId) {
        int index = theOrderMapper.deleteByPrimaryKey(orderId);
        //同时删除订单-商品对应表
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
        criteria.andOrderIdEqualTo(orderId);

        index +=orderGoodsMapper.deleteByExample(orderGoodsExample);
        return index;
    }

    @Override
    public List<Map<String, Object>> sumOrder() {
        List<Map<String, Object>> list = theOrderMapper.sumOrder();
        return list;
    }

    @Override
    public List<Map<String, Object>> sumSales() {
        List<Map<String, Object>> list = theOrderMapper.sumSales();
        return list;
    }

    @Override
    public List<Map<String, Object>> sumSalesLatestWeek() {
        List<Map<String, Object>> list = theOrderMapper.sumSalesLatestWeek();
        return list;
    }

    @Override
    public List<Map<String, Object>> sumFlowTime() {
        List<Map<String, Object>> list = theOrderMapper.sumFlowTime();
        return list;
    }
}
