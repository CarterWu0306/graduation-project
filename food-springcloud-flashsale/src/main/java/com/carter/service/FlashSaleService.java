package com.carter.service;

import com.carter.pojo.FlashSale;

public interface FlashSaleService {
    int addFlashSale(FlashSale flashSale);

    void rushFlashSale(String data);
}
