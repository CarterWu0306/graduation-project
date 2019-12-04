package com.carter.controller;

import com.alibaba.fastjson.JSON;
import com.carter.pojo.Evaluation;
import com.carter.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationServiceImpl;

    @RequestMapping(value = "/addEvaluation",method = RequestMethod.POST)
    public int addEvaluation(@RequestBody String data){
        Evaluation evaluation = JSON.parseObject(data, Evaluation.class);
        return evaluationServiceImpl.addEvaluation(evaluation);
    }
}
