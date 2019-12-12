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

    List<Map<String, Object>> getOrdersByParam(Integer userId, String tabType);

    TheOrder getOrderByOrderId(Integer orderId);

    int changeOrderStatus(TheOrder order);

    int deleteOrder(Integer orderId);

    List<Map<String, Object>> sumOrder();

    List<Map<String, Object>> sumSales();

    List<Map<String, Object>> sumSalesLatestWeek();

    List<Map<String, Object>> sumFlowTime();
}
