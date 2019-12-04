package com.carter.mapper;

import com.carter.pojo.Evaluation;
import com.carter.pojo.EvaluationExample;
import com.carter.pojo.EvaluationWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluationMapper {
    int countByExample(EvaluationExample example);

    int deleteByExample(EvaluationExample example);

    int deleteByPrimaryKey(Integer evaluationId);

    int insert(EvaluationWithBLOBs record);

    int insertSelective(EvaluationWithBLOBs record);

    List<EvaluationWithBLOBs> selectByExampleWithBLOBs(EvaluationExample example);

    List<Evaluation> selectByExample(EvaluationExample example);

    EvaluationWithBLOBs selectByPrimaryKey(Integer evaluationId);

    int updateByExampleSelective(@Param("record") EvaluationWithBLOBs record, @Param("example") EvaluationExample example);

    int updateByExampleWithBLOBs(@Param("record") EvaluationWithBLOBs record, @Param("example") EvaluationExample example);

    int updateByExample(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByPrimaryKeySelective(EvaluationWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EvaluationWithBLOBs record);

    int updateByPrimaryKey(Evaluation record);
}