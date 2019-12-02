package com.remcal.service;

import com.remcal.domain.Goods;
import com.remcal.domain.PageBean;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public interface GoodsService {
    PageBean<Goods> findByWhere(int pageN, int pageS, String condition);

    Goods findById(int gid);
}
