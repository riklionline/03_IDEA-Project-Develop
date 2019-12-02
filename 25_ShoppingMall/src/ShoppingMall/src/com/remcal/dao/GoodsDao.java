package com.remcal.dao;

import com.remcal.domain.Goods;

import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public interface GoodsDao {
    long getCount(String condition);

    List<Goods> findByWhere(int pageN, int pageS, String condition);

    Goods findById(int gid);
}
