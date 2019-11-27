package com.carter.controller;

import com.alibaba.fastjson.JSONArray;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.carter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderServiceImpl;

    @RequestMapping(value = "/addOrderByAdmin",method = RequestMethod.POST)
    public int addOrderByAdmin(@RequestParam(value = "userId") Integer userId,
                               @RequestParam(value = "totalMoney") BigDecimal totalMoney,
                               @RequestParam(value = "realTotalMoney") BigDecimal realTotalMoney,
                               @RequestParam(value = "deductionScore") Integer deductionScore,
                               @RequestParam(value = "goodsList") String goodsListJSON){
        TheOrder theOrder = new TheOrder();
        theOrder.setOrderSn(UUID.randomUUID().toString());
        theOrder.setUserId(userId);
        theOrder.setTotalMoney(totalMoney);
        theOrder.setRealTotalMoney(realTotalMoney);
        theOrder.setDeductionScore(deductionScore);
        theOrder.setOrderStatus("0");
        theOrder.setPayStatus("1");
        theOrder.setOrderCreateTime(new Date());
        theOrder.setOrderPayTime(new Date());

        List<OrderGoods> goodsList = JSONArray.parseArray(goodsListJSON, OrderGoods.class);

        return orderServiceImpl.addOrderByAdmin(theOrder,goodsList);
    }
}
