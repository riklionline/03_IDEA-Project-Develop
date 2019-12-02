package com.remcal.service;

import com.remcal.domain.GoodsType;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public interface GoodsTypeService {
    List<GoodsType> getGoodsTypeByLevel(int level);
}
