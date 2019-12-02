package com.remcal.service.impl;

import com.remcal.dao.GoodsTypeDao;
import com.remcal.dao.impl.GoodsTypeDaoImpl;
import com.remcal.domain.GoodsType;
import com.remcal.service.GoodsTypeService;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {
    GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
    @Override
    public List<GoodsType> getGoodsTypeByLevel(int level) {
        return goodsTypeDao.findByLevel(level);
    }
}
