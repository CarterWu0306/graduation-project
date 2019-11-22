package com.carter.service;

import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;

import java.util.List;

public interface OrderService {
    int addOrderByAdmin(TheOrder theOrder, List<OrderGoods> goodsList);
}
