package com.carter.mapper;

import com.carter.pojo.Evaluation;
import com.carter.pojo.EvaluationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EvaluationMapper {
    int countByExample(EvaluationExample example);

    int deleteByExample(EvaluationExample example);

    int deleteByPrimaryKey(Integer evaluationId);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    List<Evaluation> selectByExample(EvaluationExample example);

    Evaluation selectByPrimaryKey(Integer evaluationId);

    List<Map<String, Object>> selEvaluationList(@Param("starLevel") String starLevel, @Param("tabType") String tabType, @Param("startDate") String startDate);

    Map<String, Object> sumEvaluation();

    int updateByExampleSelective(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByExample(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}