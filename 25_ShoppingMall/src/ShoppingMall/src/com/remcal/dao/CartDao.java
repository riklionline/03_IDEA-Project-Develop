package com.remcal.dao;

import com.remcal.domain.Cart;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public interface CartDao {
    Cart findByGoodsIdAndUser(int gid, int uid);

    void add(Cart cart);

    void update(Cart cart);

}
