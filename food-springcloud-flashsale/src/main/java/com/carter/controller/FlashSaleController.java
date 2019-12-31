package com.carter.controller;

import com.alibaba.fastjson.JSONObject;
import com.carter.common.ResponseBo;
import com.carter.pojo.FlashSale;
import com.carter.rabbitmq.FlashSaleSender;
import com.carter.service.FlashSaleService;
import com.carter.utils.RedisUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("flashSale")
public class FlashSaleController {

    @Autowired
    private FlashSaleService flashSaleServiceImpl;
    @Autowired
    private FlashSaleSender flashSaleSender;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "addFlashSale",method = RequestMethod.POST)
    public ResponseBo addFlashSale(@RequestBody FlashSale flashSale){
        try {
            flashSaleServiceImpl.addFlashSale(flashSale);
            return ResponseBo.success(200,"新增秒杀活动成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"新增秒杀活动失败");
        }
    }

    @RequestMapping(value = "getFlashSaleList",method = RequestMethod.GET)
    public ResponseBo getFlashSaleList(int page, int limit){
        try {
            PageInfo<FlashSale> pi = flashSaleServiceImpl.getFlashSaleList(page, limit);
            return ResponseBo.list(200,"查询秒杀列表成功",pi.getTotal(),pi.getList());
        } catch (Exception e) {
            return ResponseBo.list(500,"查询秒杀列表失败",0,null);
        }
    }

    @RequestMapping(value = "deleteFlashSale",method = RequestMethod.GET)
    public ResponseBo deleteFlashSale(Integer flashSaleId){
        try {
            int index = flashSaleServiceImpl.deleteFlashSale(flashSaleId);
            return ResponseBo.success(200,"删除秒杀活动成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"删除秒杀活动失败");
        }
    }

    @RequestMapping(value = "rush",method = RequestMethod.POST)
    public ResponseBo rush(@RequestBody String data){
        try {
            JSONObject jsonObject = JSONObject.parseObject(data);
            Integer flashSaleId = (Integer)jsonObject.get("flashSaleId");
            Integer userId = (Integer)jsonObject.get("userId");
            String key = "flashSale" + flashSaleId + userId;
            if (redisUtil.lPop("flashSale-" + flashSaleId)!=null){
                if(redisUtil.get(key)!=null){
                    return ResponseBo.error(500,"该活动只限参加一次");
                }else{
                    flashSaleSender.send(data);
                    //redis设置该用户已抢购
                    redisUtil.set(key,"1");
                    return ResponseBo.success(200,"秒杀成功","");
                }
            }else{
                return ResponseBo.error(500,"已被抢光");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"秒杀失败");
        }
    }
}
