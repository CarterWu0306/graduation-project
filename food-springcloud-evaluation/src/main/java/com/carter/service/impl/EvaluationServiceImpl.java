package com.carter.service.impl;

import com.carter.mapper.EvaluationMapper;
import com.carter.pojo.Evaluation;
import com.carter.service.EvaluationService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageInfo<Map<String, Object>> getEvaluationListByParam(int page, int limit, String starLevel, String tabType, String startDate) {
        PageHelper.startPage(page,limit);

        List<Map<String, Object>> list = evaluationMapper.selEvaluationList(starLevel, tabType, startDate);

        //分页代码
        //设置分页条件
        PageInfo<Map<String, Object>> pi = new PageInfo<Map<String, Object>>(list);
        return pi;
    }

    @Override
    public Map<String, Object> sumEvaluation() {
        Map<String, Object> map = evaluationMapper.sumEvaluation();
        return map;
    }

    @Override
    public int deleteEvaluation(int evaluationId) {
        int index = evaluationMapper.deleteByPrimaryKey(evaluationId);
        return index;
    }

    @Override
    public int reply(Evaluation evaluation) {
        int index = evaluationMapper.updateByPrimaryKeySelective(evaluation);
        return index;
    }
}
