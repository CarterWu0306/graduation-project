package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "food-user")
public interface UserFeignClient {

    @RequestMapping(value = "user/addUserScore",method = RequestMethod.POST)
    int addUserScore(@RequestParam(value = "userId") Integer userId,
                     @RequestParam(value = "score")Integer score);

    @RequestMapping(value = "user/decreaseUserScore",method = RequestMethod.POST)
    int decreaseUserScore(@RequestParam(value = "userId") Integer userId,
                          @RequestParam(value = "score")Integer score);
}
