package com.carter.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.carter.common.ResponseBo;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.carter.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderServiceImpl;

    @RequestMapping(value = "/addOrderByAdmin",method = RequestMethod.POST)
    public int addOrderByAdmin(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = (Integer)jsonObject.get("userId");
        BigDecimal totalMoney = (BigDecimal)jsonObject.get("totalMoney");
        BigDecimal realTotalMoney = (BigDecimal)jsonObject.get("realTotalMoney");
        Integer deductionScore = (Integer)jsonObject.get("deductionScore");

        List<OrderGoods> goodsList = JSONArray.parseArray(jsonObject.get("goodsList").toString(), OrderGoods.class);

        TheOrder theOrder = new TheOrder();
        theOrder.setOrderSn(UUID.randomUUID().toString());
        theOrder.setUserId(userId);
        theOrder.setTotalMoney(totalMoney);
        theOrder.setRealTotalMoney(realTotalMoney);
        theOrder.setDeductionScore(deductionScore);
        theOrder.setOrderStatus("0");
        theOrder.setPayStatus("1");
        theOrder.setOrderCreateTime(new Date());
        theOrder.setOrderPayTime(new Date());

        return orderServiceImpl.addOrderByAdmin(theOrder,goodsList);
    }

    @RequestMapping(value = "getOrderList",method = RequestMethod.GET)
    public ResponseBo getOrderListByParam(int page, int limit, @RequestParam Map<String,Object> map){
        String tabType = (String)map.get("tabType");
        String dateRange = (String)map.get("dateRange");
        String orderSn = (String)map.get("orderSn");
        String startDate = "";

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置时间范围
        if (dateRange!=null&&!dateRange.equals("")){
            if (dateRange.equals("today")){
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                startDate = sdf.format(c.getTime());
            }else if (dateRange.equals("week")){
                c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)-7);
                startDate = sdf.format(c.getTime());
            }else if (dateRange.equals("month")){
                c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
                startDate = sdf.format(c.getTime());
            }
        }

        PageInfo<Map<String, Object>> pi = orderServiceImpl.getOrderListByParam(page, limit, orderSn, tabType, startDate);
        return ResponseBo.list(200,"ok",pi.getTotal(),pi.getList());
    }
}
