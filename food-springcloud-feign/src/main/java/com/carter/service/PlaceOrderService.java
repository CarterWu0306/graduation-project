package com.carter.service;

import java.math.BigDecimal;

public interface PlaceOrderService {
    int placeOrderByAdmin(Integer userId,
                          BigDecimal totalMoney,
                          BigDecimal realTotalMoney,
                          Integer deductionScore,
                          String goodsListJSON);
}
