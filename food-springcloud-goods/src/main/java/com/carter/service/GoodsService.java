package com.carter.service;

import com.carter.common.ResponseBo;
import com.carter.pojo.Goods;

import java.util.Map;

public interface GoodsService {
    int addGoods(Goods goods);

    int updateGoods(Goods goods);

    int changeGoodsStatus(Goods goods);

    int deleteGoods(int goodsId);

    ResponseBo selGoodsListByParam(int page, int limit, Map<String, Object> map);
}
