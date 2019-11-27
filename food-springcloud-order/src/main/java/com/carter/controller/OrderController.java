package com.carter.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.carter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public int addOrderByAdmin(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = (Integer)jsonObject.get("userId");
        BigDecimal totalMoney = (BigDecimal)jsonObject.get("totalMoney");
        BigDecimal realTotalMoney = (BigDecimal)jsonObject.get("realTotalMoney");
        Integer deductionScore = (Integer)jsonObject.get("deductionScore");

        List<OrderGoods> goodsList = JSONArray.parseArray(jsonObject.get("goodsList").toString(), OrderGoods.class);

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

        return orderServiceImpl.addOrderByAdmin(theOrder,goodsList);
    }
}
