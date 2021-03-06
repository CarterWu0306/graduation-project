package com.carter.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.carter.common.ResponseBo;
import com.carter.pojo.Goods;
import com.carter.pojo.OrderGoods;
import com.carter.service.GoodsService;
import com.carter.service.ImageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsServiceImpl;
    
    @Autowired
    private ImageService imageServiceImpl;

    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public ResponseBo addGoods(@RequestBody Goods goods){
        try {
            goods.setCreateTime(new Date());
            int index = goodsServiceImpl.addGoods(goods);
            if (index>0){
                return ResponseBo.success(200,"新增商品成功","");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"新增商品失败");
        }
        return ResponseBo.error(500,"新增商品失败");
    }

    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public ResponseBo updateGoods(@RequestBody Goods goods){
        try {
            goods.setCreateTime(new Date());
            int index = goodsServiceImpl.updateGoods(goods);
            if (index>0){
                return ResponseBo.success(200,"编辑商品成功","");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"编辑商品失败");
        }
        return ResponseBo.error(500,"编辑商品失败");
    }

    @RequestMapping(value = "/changeGoodsStatus",method = RequestMethod.POST)
    public ResponseBo changeGoodsStatus(@RequestBody Goods goods){
        try {
            goods.setCreateTime(new Date());
            int index = goodsServiceImpl.changeGoodsStatus(goods);
            if (index>0){
                if (goods.getGoodsStatus().equals(0)){
                    return ResponseBo.success(200,"下架商品成功","");
                }else{
                    return ResponseBo.success(200,"上架商品成功","");
                }
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"上/下架商品失败");
        }
        return ResponseBo.error(500,"上/下架商品失败");
    }

    @RequestMapping(value = "/deleteGoods",method = RequestMethod.GET)
    public ResponseBo deleteGoods(@RequestParam(value = "goodsId") int goodsId){
        try {
            int index = goodsServiceImpl.deleteGoods(goodsId);
            if (index>0){
                return ResponseBo.success(200,"删除商品成功","");
            }
        } catch (Exception e) {
            return ResponseBo.error(500,"删除商品失败");
        }
        return ResponseBo.error(500,"删除商品失败");
    }

    @RequestMapping(value = "/decreaseGoodsStock",method = RequestMethod.POST)
    public int decreaseGoodsStock(@RequestBody String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        List<OrderGoods> goodsList = JSONArray.parseArray(jsonObject.get("goodsList").toString(), OrderGoods.class);
        return goodsServiceImpl.decreaseGoodsStock(goodsList);
    }

    /**
     * 上传并返回识别结果
     * @param mfile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/uploadAndReconizeImage",method = RequestMethod.POST)
    public ResponseBo uploadAndReconizeImage(@RequestParam(value = "file") MultipartFile mfile){
        try {
            //识别
            String recognize = imageServiceImpl.recognizeImage(mfile);
            Map recognizeObj = (Map)JSON.parse(recognize);
            //上传
            String uploadResult = imageServiceImpl.uploadImage(mfile,"http://images.wukate.com/defaultGoods.jpg");
            if (uploadResult!="http://images.wukate.com/defaultGoods.jpg"){
                recognizeObj.put("ImgURL",uploadResult);
                return ResponseBo.success(200,"上传成功",recognizeObj);
            }
        } catch (IOException e) {
            return ResponseBo.error(500,"上传失败");
        }
        return ResponseBo.error(500,"上传失败");
    }

    @RequestMapping(value = "/selGoodsList",method = RequestMethod.GET)
    public ResponseBo selGoodsListByParam(int page, int limit, @RequestParam Map<String, Object> map){
        try {
            PageInfo<Goods> pi = goodsServiceImpl.selGoodsListByParam(page, limit, map);
            return ResponseBo.list(200,"查询商品列表成功",pi.getTotal(),pi.getList());
        } catch (Exception e) {
            return ResponseBo.list(500,"查询商品列表失败",0,null);
        }
    }

    @RequestMapping(value = "/selAllGoodsList",method = RequestMethod.GET)
    public ResponseBo selAllGoodsList(){
        try {
            List<Goods> goods = goodsServiceImpl.selAllGoodsList();
            return ResponseBo.success(200,"查询全部商品成功",goods);
        } catch (Exception e) {
            return ResponseBo.error(500,"查询全部商品失败");
        }
    }

    @RequestMapping(value = "/selGoodsLabel",method = RequestMethod.GET)
    public ResponseBo selGoodsLabel(){
        try {
            List<String> labelList = goodsServiceImpl.selGoodsLabel();
            return ResponseBo.success(200,"查询商品标签成功",labelList);
        } catch (Exception e) {
            return ResponseBo.error(500,"查询商品标签失败");
        }
    }


    @RequestMapping(value = "/sumGoods",method = RequestMethod.GET)
    public ResponseBo sumGoods(){
        try {
            List<Map<String, Object>> data = goodsServiceImpl.sumGoods();
            return ResponseBo.success(200,"统计历史商品数量成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计历史商品数量失败");
        }
    }

    @RequestMapping(value = "/sumHotGoods",method = RequestMethod.GET)
    public ResponseBo sumHotGoods(){
        try {
            List<Map<String, Object>> data = goodsServiceImpl.sumHotGoods();
            return ResponseBo.success(200,"统计热销商品成功",data);
        } catch (Exception e) {
            return ResponseBo.error(500,"统计热销商品失败");
        }
    }
}
