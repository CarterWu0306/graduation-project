package com.carter.controller;

import com.alibaba.fastjson.JSON;
import com.carter.common.ResponseBo;
import com.carter.pojo.Evaluation;
import com.carter.service.EvaluationService;
import com.carter.service.ImageService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationServiceImpl;
    @Autowired
    private ImageService imageServiceImpl;

    @RequestMapping(value = "/addEvaluation",method = RequestMethod.POST)
    public int addEvaluation(@RequestBody String data){
        Evaluation evaluation = JSON.parseObject(data, Evaluation.class);
        return evaluationServiceImpl.addEvaluation(evaluation);
    }

    @RequestMapping(value = "getEvaluationList",method = RequestMethod.GET)
    public ResponseBo getEvaluationList(int page, int limit, @RequestParam Map<String,Object> map){
        try {
            String tabType = (String)map.get("tabType");
            String dateRange = (String)map.get("dateRange");
            String starLevel = (String)map.get("starLevel");
            String startDate = "";

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //设置时间范围
            if (!StringUtils.isBlank(dateRange)){
                if (dateRange.equals("week")){
                    c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-7);
                    startDate = sdf.format(c.getTime());
                }else if (dateRange.equals("month")){
                    c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
                    startDate = sdf.format(c.getTime());
                }
            }

            PageInfo<Map<String, Object>> pi = evaluationServiceImpl.getEvaluationListByParam(page, limit, starLevel, tabType, startDate);
            return ResponseBo.list(200,"查询评价列表成功",pi.getTotal(),pi.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBo.list(500,"查询评价列表失败",0,null);
        }
    }

    @RequestMapping(value = "getAllEvaluationByParam",method = RequestMethod.GET)
    public ResponseBo getAllEvaluationByParam(@RequestParam Map<String,Object> map){
        try {
            String starLevel = (String)map.get("starLevel");
            List<Map<String, Object>> data = evaluationServiceImpl.getEvaluationByParam(starLevel);
            return ResponseBo.success(200,"查询全部评价成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"查询全部评价失败");
        }
    }

    @RequestMapping(value = "sumEvaluation",method = RequestMethod.GET)
    public ResponseBo sumEvaluation(){
        try {
            Map<String, Object> map = evaluationServiceImpl.sumEvaluation();
            return ResponseBo.success(200,"统计评价成功",map);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计评价失败");
        }
    }

    @RequestMapping(value = "deleteEvaluation",method = RequestMethod.POST)
    public ResponseBo deleteEvaluation(@RequestParam(value = "evaluationId") int evaluationId){
        try {
            int index = evaluationServiceImpl.deleteEvaluation(evaluationId);
            return ResponseBo.success(200,"删除评价成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"删除评价失败");
        }
    }

    @RequestMapping(value = "reply",method = RequestMethod.POST)
    public ResponseBo reply(@RequestBody Evaluation evaluation){
        try {
            evaluationServiceImpl.reply(evaluation);
            return ResponseBo.success(200,"回复评价成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"回复评价失败");
        }
    }

    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public ResponseBo uploadImage(@RequestParam(value = "file") MultipartFile mfile){
        try {
            String uploadResult = imageServiceImpl.uploadImage(mfile,"http://images.wukate.com/defaultEvaluation.jpg");
            if (uploadResult!="http://images.wukate.com/defaultEvaluation.jpg"){
                return ResponseBo.success(200,"上传成功",uploadResult);
            }
        } catch (IOException e) {
            return ResponseBo.error(500,"上传失败");
        }
        return ResponseBo.error(500,"上传失败");
    }
}
