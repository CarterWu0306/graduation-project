package com.carter.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TheOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TheOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIsNull() {
            addCriterion("order_details is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIsNotNull() {
            addCriterion("order_details is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsEqualTo(String value) {
            addCriterion("order_details =", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNotEqualTo(String value) {
            addCriterion("order_details <>", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsGreaterThan(String value) {
            addCriterion("order_details >", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("order_details >=", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsLessThan(String value) {
            addCriterion("order_details <", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsLessThanOrEqualTo(String value) {
            addCriterion("order_details <=", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsLike(String value) {
            addCriterion("order_details like", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNotLike(String value) {
            addCriterion("order_details not like", value, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsIn(List<String> values) {
            addCriterion("order_details in", values, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNotIn(List<String> values) {
            addCriterion("order_details not in", values, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsBetween(String value1, String value2) {
            addCriterion("order_details between", value1, value2, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderDetailsNotBetween(String value1, String value2) {
            addCriterion("order_details not between", value1, value2, "orderDetails");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("total_money is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("total_money is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("total_money =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("total_money <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("total_money >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(BigDecimal value) {
            addCriterion("total_money <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_money <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("total_money in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("total_money not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_money not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyIsNull() {
            addCriterion("real_total_money is null");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyIsNotNull() {
            addCriterion("real_total_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("real_total_money =", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("real_total_money <>", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("real_total_money >", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_total_money >=", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyLessThan(BigDecimal value) {
            addCriterion("real_total_money <", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_total_money <=", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("real_total_money in", values, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("real_total_money not in", values, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_total_money between", value1, value2, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_total_money not between", value1, value2, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("pay_status like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("pay_status not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreIsNull() {
            addCriterion("deduction_score is null");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreIsNotNull() {
            addCriterion("deduction_score is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreEqualTo(Integer value) {
            addCriterion("deduction_score =", value, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreNotEqualTo(Integer value) {
            addCriterion("deduction_score <>", value, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreGreaterThan(Integer value) {
            addCriterion("deduction_score >", value, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduction_score >=", value, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreLessThan(Integer value) {
            addCriterion("deduction_score <", value, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreLessThanOrEqualTo(Integer value) {
            addCriterion("deduction_score <=", value, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreIn(List<Integer> values) {
            addCriterion("deduction_score in", values, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreNotIn(List<Integer> values) {
            addCriterion("deduction_score not in", values, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreBetween(Integer value1, Integer value2) {
            addCriterion("deduction_score between", value1, value2, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andDeductionScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("deduction_score not between", value1, value2, "deductionScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreIsNull() {
            addCriterion("order_score is null");
            return (Criteria) this;
        }

        public Criteria andOrderScoreIsNotNull() {
            addCriterion("order_score is not null");
            return (Criteria) this;
        }

        public Criteria andOrderScoreEqualTo(Integer value) {
            addCriterion("order_score =", value, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreNotEqualTo(Integer value) {
            addCriterion("order_score <>", value, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreGreaterThan(Integer value) {
            addCriterion("order_score >", value, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_score >=", value, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreLessThan(Integer value) {
            addCriterion("order_score <", value, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreLessThanOrEqualTo(Integer value) {
            addCriterion("order_score <=", value, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreIn(List<Integer> values) {
            addCriterion("order_score in", values, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreNotIn(List<Integer> values) {
            addCriterion("order_score not in", values, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreBetween(Integer value1, Integer value2) {
            addCriterion("order_score between", value1, value2, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("order_score not between", value1, value2, "orderScore");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksIsNull() {
            addCriterion("order_remarks is null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksIsNotNull() {
            addCriterion("order_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksEqualTo(String value) {
            addCriterion("order_remarks =", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotEqualTo(String value) {
            addCriterion("order_remarks <>", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksGreaterThan(String value) {
            addCriterion("order_remarks >", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("order_remarks >=", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksLessThan(String value) {
            addCriterion("order_remarks <", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksLessThanOrEqualTo(String value) {
            addCriterion("order_remarks <=", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksLike(String value) {
            addCriterion("order_remarks like", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotLike(String value) {
            addCriterion("order_remarks not like", value, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksIn(List<String> values) {
            addCriterion("order_remarks in", values, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotIn(List<String> values) {
            addCriterion("order_remarks not in", values, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksBetween(String value1, String value2) {
            addCriterion("order_remarks between", value1, value2, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderRemarksNotBetween(String value1, String value2) {
            addCriterion("order_remarks not between", value1, value2, "orderRemarks");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNull() {
            addCriterion("is_refund is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNotNull() {
            addCriterion("is_refund is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundEqualTo(String value) {
            addCriterion("is_refund =", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotEqualTo(String value) {
            addCriterion("is_refund <>", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThan(String value) {
            addCriterion("is_refund >", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThanOrEqualTo(String value) {
            addCriterion("is_refund >=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThan(String value) {
            addCriterion("is_refund <", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThanOrEqualTo(String value) {
            addCriterion("is_refund <=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLike(String value) {
            addCriterion("is_refund like", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotLike(String value) {
            addCriterion("is_refund not like", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundIn(List<String> values) {
            addCriterion("is_refund in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotIn(List<String> values) {
            addCriterion("is_refund not in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundBetween(String value1, String value2) {
            addCriterion("is_refund between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotBetween(String value1, String value2) {
            addCriterion("is_refund not between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseIsNull() {
            addCriterion("is_appraise is null");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseIsNotNull() {
            addCriterion("is_appraise is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseEqualTo(String value) {
            addCriterion("is_appraise =", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotEqualTo(String value) {
            addCriterion("is_appraise <>", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseGreaterThan(String value) {
            addCriterion("is_appraise >", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseGreaterThanOrEqualTo(String value) {
            addCriterion("is_appraise >=", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseLessThan(String value) {
            addCriterion("is_appraise <", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseLessThanOrEqualTo(String value) {
            addCriterion("is_appraise <=", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseLike(String value) {
            addCriterion("is_appraise like", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotLike(String value) {
            addCriterion("is_appraise not like", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseIn(List<String> values) {
            addCriterion("is_appraise in", values, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotIn(List<String> values) {
            addCriterion("is_appraise not in", values, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseBetween(String value1, String value2) {
            addCriterion("is_appraise between", value1, value2, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotBetween(String value1, String value2) {
            addCriterion("is_appraise not between", value1, value2, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIsNull() {
            addCriterion("order_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIsNotNull() {
            addCriterion("order_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeEqualTo(Date value) {
            addCriterion("order_pay_time =", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotEqualTo(Date value) {
            addCriterion("order_pay_time <>", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeGreaterThan(Date value) {
            addCriterion("order_pay_time >", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_pay_time >=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeLessThan(Date value) {
            addCriterion("order_pay_time <", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_pay_time <=", value, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeIn(List<Date> values) {
            addCriterion("order_pay_time in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotIn(List<Date> values) {
            addCriterion("order_pay_time not in", values, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeBetween(Date value1, Date value2) {
            addCriterion("order_pay_time between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }

        public Criteria andOrderPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_pay_time not between", value1, value2, "orderPayTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}