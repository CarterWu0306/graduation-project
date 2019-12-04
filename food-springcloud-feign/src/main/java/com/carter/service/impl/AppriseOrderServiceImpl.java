package com.carter.service.impl;

import com.carter.feign.EvaluationFeignClient;
import com.carter.feign.OrderFeignClient;
import com.carter.service.AppriseOrderService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppriseOrderServiceImpl implements AppriseOrderService {

    @Autowired
    private EvaluationFeignClient evaluationFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int appriseOrder(String data) {
        int index = evaluationFeignClient.addEvaluation(data);
        //同时修改订单为已评价
        index += orderFeignClient.changeOrderStatusToAppraised(data);
        return index;
    }
}
