package com.remcal.service.impl;

import com.remcal.dao.GoodsDao;
import com.remcal.dao.GoodsTypeDao;
import com.remcal.dao.impl.GoodsDaoImpl;
import com.remcal.dao.impl.GoodsTypeDaoImpl;
import com.remcal.domain.Goods;
import com.remcal.domain.GoodsType;
import com.remcal.domain.PageBean;
import com.remcal.service.GoodsService;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public PageBean<Goods> findByWhere(int pageN, int pageS, String condition) {
        //获取数据个数
        long totalSize=goodsDao.getCount(condition);
        //获取当前页数据
        List<Goods> data=goodsDao.findByWhere(pageN, pageS,condition);
        PageBean<Goods> pageBean=new PageBean<>(pageN, pageS, totalSize ,data );
        return pageBean;
    }

    @Override
    public Goods findById(int gid) {
        Goods goods = goodsDao.findById(gid);
        //根据商品类型id查询商品类型
        GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
        GoodsType goodsType=goodsTypeDao.findById(goods.getTypeId());
        goods.setGoodsType(goodsType);
        return goods;
    }
}
