package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "food-order")
public interface OrderFeignClient {

    @RequestMapping(value = "order/addOrderByAdmin",method = RequestMethod.POST)
    int addOrderByAdmin(@RequestBody String data);
}
