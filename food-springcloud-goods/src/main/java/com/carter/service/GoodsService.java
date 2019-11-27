package com.carter.service;

import com.carter.common.ResponseBo;
import com.carter.pojo.Goods;
import com.carter.pojo.OrderGoods;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    int changeGoodsStatus(Goods goods);

    int deleteGoods(int goodsId);

    int decreaseGoodsStock(List<OrderGoods> goodsList);

    PageInfo<Goods> selGoodsListByParam(int page, int limit, Map<String, Object> map);
}
