package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "food-order")
public interface OrderFeignClient {

    @RequestMapping(value = "order/addOrderByAdmin",method = RequestMethod.POST)
    int addOrderByAdmin(@RequestParam(value = "userId") Integer userId,
                        @RequestParam(value = "totalMoney") BigDecimal totalMoney,
                        @RequestParam(value = "realTotalMoney") BigDecimal realTotalMoney,
                        @RequestParam(value = "deductionScore") Integer deductionScore,
                        @RequestParam(value = "goodsList") String goodsListJSON);
}
