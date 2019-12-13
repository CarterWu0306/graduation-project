package com.carter.service;


public interface PlaceOrderService {
    int placeOrderByAdmin(String data);

    int placeOrderByUser(String data);

    int payOrder(String data);
}
