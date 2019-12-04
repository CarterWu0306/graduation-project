package com.carter.controller;

import com.carter.common.ResponseBo;
import com.carter.service.AppriseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppriseOrderController {

    @Autowired
    private AppriseOrderService appriseOrderServiceImpl;

    @RequestMapping(value = "appriseOrder",method = RequestMethod.POST)
    public ResponseBo appriseOrder(@RequestBody String data){
        try {
            appriseOrderServiceImpl.appriseOrder(data);
            return ResponseBo.success(200,"评价成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"评价失败");
        }
    }
}
