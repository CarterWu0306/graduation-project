package com.carter.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TheOrder {
    private Integer orderId;

    private String orderSn;

    private Integer userId;

    private String orderDetails;

    private String orderStatus;

    private BigDecimal totalMoney;

    private BigDecimal realTotalMoney;

    private String payStatus;

    private Integer deductionScore;

    private Integer orderScore;

    private String orderRemarks;

    private String isRefund;

    private String isAppraise;

    private Date orderCreateTime;

    private Date orderPayTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails == null ? null : orderDetails.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getRealTotalMoney() {
        return realTotalMoney;
    }

    public void setRealTotalMoney(BigDecimal realTotalMoney) {
        this.realTotalMoney = realTotalMoney;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public Integer getDeductionScore() {
        return deductionScore;
    }

    public void setDeductionScore(Integer deductionScore) {
        this.deductionScore = deductionScore;
    }

    public Integer getOrderScore() {
        return orderScore;
    }

    public void setOrderScore(Integer orderScore) {
        this.orderScore = orderScore;
    }

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks == null ? null : orderRemarks.trim();
    }

    public String getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund == null ? null : isRefund.trim();
    }

    public String getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(String isAppraise) {
        this.isAppraise = isAppraise == null ? null : isAppraise.trim();
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }
}