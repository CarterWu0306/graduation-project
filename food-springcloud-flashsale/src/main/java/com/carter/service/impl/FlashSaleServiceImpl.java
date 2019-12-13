package com.carter.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carter.feign.UserFeignClient;
import com.carter.mapper.FlashSaleMapper;
import com.carter.pojo.FlashSale;
import com.carter.service.FlashSaleService;
import com.carter.utils.RedisUtil;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class FlashSaleServiceImpl implements FlashSaleService {

    @Resource
    private FlashSaleMapper flashSaleMapper;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int addFlashSale(FlashSale flashSale) {
        //数据库新增秒杀信息
        int index = flashSaleMapper.insertSelective(flashSale);
        //redis缓存秒杀信息
        index += redisUtil.set("flashSale-"+flashSale.getFlashSaleId(),flashSale.getStock());
        return index;
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public void rushFlashSale(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer flashSaleId = (Integer)jsonObject.get("flashSaleId");
        Integer userId = (Integer)jsonObject.get("userId");

        //减少数据库秒杀活动库存
        FlashSale flashSale = flashSaleMapper.selectByPrimaryKey(flashSaleId);
        flashSale.setStock(flashSale.getStock()-1);
        int index = flashSaleMapper.updateByPrimaryKeySelective(flashSale);

        //增加用户积分
        Map<String,Integer> map=new HashMap<>();
        map.put("userId",userId);
        map.put("score",flashSale.getScore());
        String jsonString = JSON.toJSONString(map);
        userFeignClient.addFlashScore(jsonString);

        System.out.println("抢购成功");
    }
}
