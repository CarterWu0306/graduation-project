package com.carter.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "food-evaluation")
public interface EvaluationFeignClient {

    @RequestMapping(value = "evaluation/addEvaluation",method = RequestMethod.POST)
    int addEvaluation(@RequestBody String data);
}
