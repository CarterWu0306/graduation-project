package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "food-user")
public interface UserFeignClient {

    @RequestMapping(value = "user/addFlashScore",method = RequestMethod.POST)
    int addFlashScore(@RequestBody String data);
}
