package com.remcal.dao;

import com.remcal.domain.GoodsType;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public interface GoodsTypeDao {
    List<GoodsType> findByLevel(int level);

    GoodsType findById(Integer typeId);
}
