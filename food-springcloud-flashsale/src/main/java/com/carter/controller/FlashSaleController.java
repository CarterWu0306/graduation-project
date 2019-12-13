package com.carter.controller;

import com.alibaba.fastjson.JSONObject;
import com.carter.common.ResponseBo;
import com.carter.pojo.FlashSale;
import com.carter.rabbitmq.FlashSaleSender;
import com.carter.service.FlashSaleService;
import com.carter.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            int index = flashSaleServiceImpl.addFlashSale(flashSale);
            return ResponseBo.success(200,"新增秒杀活动成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"新增秒杀活动失败");
        }
    }

    @RequestMapping(value = "rush",method = RequestMethod.POST)
    public ResponseBo rush(@RequestBody String data){
        try {
            JSONObject jsonObject = JSONObject.parseObject(data);
            Integer flashSaleId = (Integer)jsonObject.get("flashSaleId");
            Integer userId = (Integer)jsonObject.get("userId");
            String key = "flashSale" + flashSaleId + userId;
            Integer stock = (Integer)redisUtil.get("flashSale-" + flashSaleId);
            if (stock>0){
                if(redisUtil.get(key)!=null){
                    return ResponseBo.error(222,"该活动只限参加一次");
                }else{
                    flashSaleSender.send(data);
                    //减少redis缓存中库存
                    redisUtil.set("flashSale-"+flashSaleId,stock-1);
                    //redis设置该用户已抢购
                    redisUtil.set(key,"1");
                    return ResponseBo.success(200,"秒杀成功","");
                }
            }else{
                return ResponseBo.error(111,"已被抢光");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"秒杀失败");
        }
    }
}
