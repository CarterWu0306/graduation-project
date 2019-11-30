package com.carter.service;

import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface OrderService {
    int addOrderByAdmin(TheOrder theOrder, List<OrderGoods> goodsList);

    PageInfo<Map<String, Object>> getOrderListByParam(int page, int limit, String orderSn, String tabType, String startDate);

    List<Map<String, Object>> getAllOrders();

    TheOrder getOrderByOrderId(Integer orderId);

    int changeOrderStatus(TheOrder order);

    int deleteOrder(Integer orderId);
}
