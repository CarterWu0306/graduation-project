package com.carter.controller;

import com.carter.common.ResponseBo;
import com.carter.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("placeOrder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderServiceImpl;

    @RequestMapping(value = "placeOrderByAdmin",method = RequestMethod.POST)
    public ResponseBo placeOrderByAdmin(@RequestBody String data){
        try {
            int index = placeOrderServiceImpl.placeOrderByAdmin(data);
            return ResponseBo.success(200,"下单成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"下单失败");
        }
    }
}
