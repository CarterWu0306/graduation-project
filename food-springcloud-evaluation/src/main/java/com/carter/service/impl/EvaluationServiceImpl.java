package com.carter.service.impl;

import com.carter.mapper.EvaluationMapper;
import com.carter.pojo.Evaluation;
import com.carter.service.EvaluationService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Resource
    private EvaluationMapper evaluationMapper;

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int addEvaluation(Evaluation evaluation) {
        int index = evaluationMapper.insertSelective(evaluation);
        return index;
    }
}
