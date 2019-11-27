package com.carter.service.impl;

import com.carter.feign.GoodsFeignClient;
import com.carter.feign.OrderFeignClient;
import com.carter.feign.UserFeignClient;
import com.carter.service.PlaceOrderService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private GoodsFeignClient goodsFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int placeOrderByAdmin(String data) {
        int index = goodsFeignClient.decreaseGoodsStock(data);
        index += orderFeignClient.addOrderByAdmin(data);
        return index;
    }
}
