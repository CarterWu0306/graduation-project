package com.carter.controller;

import com.carter.common.ResponseBo;
import com.carter.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("placeOrder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderServiceImpl;

    @RequestMapping(value = "placeOrderByAdmin",method = RequestMethod.POST)
    public ResponseBo placeOrderByAdmin(@RequestParam(value = "userId") Integer userId,
                                        @RequestParam(value = "totalMoney") BigDecimal totalMoney,
                                        @RequestParam(value = "realTotalMoney") BigDecimal realTotalMoney,
                                        @RequestParam(value = "deductionScore") Integer deductionScore,
                                        @RequestParam(value = "goodsList") String goodsListJSON){
        try {
            int index = placeOrderServiceImpl.placeOrderByAdmin(userId, totalMoney, realTotalMoney, deductionScore, goodsListJSON);
            return ResponseBo.success(200,"下单成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"下单失败");
        }
    }
}
