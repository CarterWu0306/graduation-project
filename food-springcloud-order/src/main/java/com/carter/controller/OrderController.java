package com.carter.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.carter.common.ResponseBo;
import com.carter.pojo.OrderGoods;
import com.carter.pojo.TheOrder;
import com.carter.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
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
        String totalMoney = (String)jsonObject.get("totalMoney");
        String realTotalMoney = (String)jsonObject.get("realTotalMoney");
        Integer deductionScore = (Integer)jsonObject.get("deductionScore");

        List<OrderGoods> goodsList = JSONArray.parseArray(jsonObject.get("goodsList").toString(), OrderGoods.class);

        TheOrder theOrder = new TheOrder();
        theOrder.setOrderSn(UUID.randomUUID().toString());
        theOrder.setUserId(userId);
        theOrder.setTotalMoney(new BigDecimal(totalMoney));
        theOrder.setRealTotalMoney(new BigDecimal(realTotalMoney));
        theOrder.setDeductionScore(deductionScore);
        theOrder.setOrderStatus("0");
        theOrder.setPayStatus("1");
        theOrder.setOrderCreateTime(new Date());
        theOrder.setOrderPayTime(new Date());

        return orderServiceImpl.addOrderByAdmin(theOrder,goodsList);
    }

    @RequestMapping(value = "/addOrderByUser",method = RequestMethod.POST)
    public int addOrderByUser(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer userId = (Integer)jsonObject.get("userId");
        String totalMoney = (String)jsonObject.get("totalMoney");
        String realTotalMoney = (String)jsonObject.get("realTotalMoney");
        Integer deductionScore = (Integer)jsonObject.get("deductionScore");

        List<OrderGoods> goodsList = JSONArray.parseArray(jsonObject.get("goodsList").toString(), OrderGoods.class);

        TheOrder theOrder = new TheOrder();
        theOrder.setOrderSn(UUID.randomUUID().toString());
        theOrder.setUserId(userId);
        theOrder.setTotalMoney(new BigDecimal(totalMoney));
        theOrder.setRealTotalMoney(new BigDecimal(realTotalMoney));
        theOrder.setDeductionScore(deductionScore);
        theOrder.setOrderStatus("-1");
        theOrder.setPayStatus("0");
        theOrder.setOrderCreateTime(new Date());
        theOrder.setOrderPayTime(new Date());

        return orderServiceImpl.addOrderByAdmin(theOrder,goodsList);
    }


    @RequestMapping(value = "getOrderList",method = RequestMethod.GET)
    public ResponseBo getOrderListByParam(int page, int limit, @RequestParam Map<String,Object> map){
        try {
            String tabType = (String)map.get("tabType");
            String dateRange = (String)map.get("dateRange");
            String orderSn = (String)map.get("orderSn");
            String startDate = "";

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //设置时间范围
            if (!StringUtils.isBlank(dateRange)){
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
            return ResponseBo.list(200,"查询订单成功",pi.getTotal(),pi.getList());
        } catch (Exception e) {
            return ResponseBo.list(500,"查询订单失败",0,null);
        }
    }

    @RequestMapping(value = "getAllOrders",method = RequestMethod.GET)
    public ResponseBo getAllOrders(){
        try {
            List<Map<String, Object>> allOrders = orderServiceImpl.getAllOrders();
            return ResponseBo.success(200,"查询所有订单成功",allOrders);
        } catch (Exception e) {
            return ResponseBo.error(500,"查询所有订单失败");
        }
    }

    @RequestMapping(value = "getOrdersByParam",method = RequestMethod.GET)
    public ResponseBo getOrdersByParam(int userId, String tabType){
        try {
            System.out.println("userId:"+userId+"   tabType:"+tabType);
            List<Map<String, Object>> data = orderServiceImpl.getOrdersByParam(userId,tabType);
            return ResponseBo.success(200,"用户查询订单成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"用户查询订单失败");
        }
    }

    @RequestMapping(value = "completeOrder",method = RequestMethod.POST)
    public ResponseBo completeOrder(@RequestBody TheOrder order){
        try {
            order.setOrderStatus("1");
            orderServiceImpl.changeOrderStatus(order);
            return ResponseBo.success(200,"完成订单成功","");
        } catch (Exception e) {
            return ResponseBo.error(500,"完成订单失败");
        }
    }

    @RequestMapping(value = "changeOrderStatusToAppraised",method = RequestMethod.POST)
    public int changeOrderStatusToAppraised(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        Integer orderId = (Integer)jsonObject.get("orderId");
        TheOrder order = new TheOrder();
        order.setOrderId(orderId);
        order.setIsAppraise("1");
        return orderServiceImpl.changeOrderStatus(order);
    }

    @RequestMapping(value = "deleteOrder",method = RequestMethod.GET)
    public ResponseBo deleteOrder(@RequestParam("orderId") Integer orderId){
        try {
            orderServiceImpl.deleteOrder(orderId);
            return ResponseBo.success(200,"删除订单成功","");
        }catch (Exception e) {
            return ResponseBo.error(500,"删除订单失败");
        }
    }

    @RequestMapping(value = "/sumOrder",method = RequestMethod.GET)
    public ResponseBo sumOrder(){
        try {
            List<Map<String, Object>> data = orderServiceImpl.sumOrder();
            return ResponseBo.success(200,"统计新增订单数成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计新增订单数失败");
        }
    }

    @RequestMapping(value = "/sumSales",method = RequestMethod.GET)
    public ResponseBo sumSales(){
        try {
            List<Map<String, Object>> data = orderServiceImpl.sumSales();
            return ResponseBo.success(200,"统计销售额成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计销售额失败");
        }
    }

    @RequestMapping(value = "/sumSalesLatestWeek",method = RequestMethod.GET)
    public ResponseBo sumSalesLatestWeek(){
        try {
            List<Map<String, Object>> data = orderServiceImpl.sumSalesLatestWeek();
            return ResponseBo.success(200,"统计最近一周销售额成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计最近一周销售额失败");
        }
    }

    @RequestMapping(value = "/sumFlowTime",method = RequestMethod.GET)
    public ResponseBo sumFlowTime(){
        try {
            List<Map<String, Object>> data = orderServiceImpl.sumFlowTime();
            return ResponseBo.success(200,"统计本月客流量时间段成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计本月客流量时间段失败");
        }
    }
}
