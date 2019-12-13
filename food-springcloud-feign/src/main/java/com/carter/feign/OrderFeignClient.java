package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "food-order")
public interface OrderFeignClient {

    @RequestMapping(value = "order/addOrderByAdmin",method = RequestMethod.POST)
    int addOrderByAdmin(@RequestBody String data);

    @RequestMapping(value = "order/addOrderByUser",method = RequestMethod.POST)
    int addOrderByUser(@RequestBody String data);

    @RequestMapping(value = "order/changeOrderStatusToAppraised",method = RequestMethod.POST)
    int changeOrderStatusToAppraised(@RequestBody String data);

    @RequestMapping(value = "order/payOrder",method = RequestMethod.POST)
    int payOrder(@RequestBody String data);
}
