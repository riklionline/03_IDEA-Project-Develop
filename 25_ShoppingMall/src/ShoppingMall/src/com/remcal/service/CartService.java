package com.remcal.service;

import com.remcal.domain.Cart;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public interface CartService {
    Cart findByGoodsIdAndUser(int gid, int id);

    void add(Cart cart);

    void update(Cart cart);
}
