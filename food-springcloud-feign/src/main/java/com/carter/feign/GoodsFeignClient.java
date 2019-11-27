package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "food-goods")
public interface GoodsFeignClient {

    @RequestMapping(value = "goods/decreaseGoodsStock",method = RequestMethod.POST)
    int decreaseGoodsStock(@RequestBody String goodsListJSON);
}
