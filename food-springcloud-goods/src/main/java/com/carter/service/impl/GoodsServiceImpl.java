package com.carter.service.impl;

import com.carter.common.ResponseBo;
import com.carter.mapper.GoodsMapper;
import com.carter.pojo.Goods;
import com.carter.pojo.GoodsExample;
import com.carter.service.GoodsService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int addGoods(Goods goods) {
        int index = goodsMapper.insertSelective(goods);
        return index;
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int updateGoods(Goods goods) {
        int index = goodsMapper.updateByPrimaryKey(goods);
        return index;
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int changeGoodsStatus(Goods goods) {
        int index = goodsMapper.updateByPrimaryKeySelective(goods);
        return index;
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int deleteGoods(int goodsId) {
        int index = goodsMapper.deleteByPrimaryKey(goodsId);
        return index;
    }

    @Override
    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    public int decreaseGoodsStock(int goodsId, int goodsNum) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        //库存足够
        if (goods.getGoodsStock()>=goodsNum){
            goods.setGoodsStock(goods.getGoodsStock()-goodsNum);
            int index = goodsMapper.updateByPrimaryKeySelective(goods);
            return index;
        }else{
            //库存不足
            return 0;
        }
    }

    @Override
    public PageInfo<Goods> selGoodsListByParam(int page, int limit, Map<String, Object> map) {
        PageHelper.startPage(page,limit);

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();

        String goodsName = (String)map.get("goodsName");
        String goodsLabel = (String)map.get("goodsLabel");
        String goodsStatus = (String)map.get("goodsStatus");

        //设置查询条件
        if (goodsName!=null && !goodsName.equals("")){
            criteria.andGoodsNameEqualTo(goodsName);
        }
        if (goodsLabel!=null && !goodsLabel.equals("")){
            criteria.andGoodsLabelEqualTo(goodsLabel);
        }
        if (goodsStatus!=null && !goodsStatus.equals("")){
            criteria.andGoodsStatusEqualTo(goodsStatus);
        }

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);

        //分页代码
        //设置分页条件
        PageInfo<Goods> pi = new PageInfo<>(goodsList);

        return pi;
    }
}
