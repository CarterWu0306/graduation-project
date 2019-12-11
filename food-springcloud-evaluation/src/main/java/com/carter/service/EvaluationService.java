package com.carter.service;

import com.carter.pojo.Evaluation;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface EvaluationService {
    int addEvaluation(Evaluation evaluation);

    PageInfo<Map<String, Object>> getEvaluationListByParam(int page, int limit, String starLevel, String tabType, String startDate);

    List<Evaluation> getEvaluationByParam(String starLevel);

    Map<String, Object> sumEvaluation();

    int deleteEvaluation(int evaluationId);

    int reply(Evaluation evaluation);
}
