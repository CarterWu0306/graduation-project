package com.carter.service;

import com.carter.pojo.FlashSale;
import com.github.pagehelper.PageInfo;

public interface FlashSaleService {
    void addFlashSale(FlashSale flashSale);

    int deleteFlashSale(Integer flashSaleId);

    PageInfo<FlashSale> getFlashSaleList(int page, int limit);

    void rushFlashSale(String data);
}
