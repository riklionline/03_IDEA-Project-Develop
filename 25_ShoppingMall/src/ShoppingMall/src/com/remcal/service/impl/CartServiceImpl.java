package com.remcal.service.impl;

import com.remcal.dao.CartDao;
import com.remcal.dao.impl.CartDaoImpl;
import com.remcal.domain.Cart;
import com.remcal.service.CartService;

/**
 * @ClassName: test
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 11/11/2019 6:26 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class CartServiceImpl implements CartService {
    CartDao cartDao=new CartDaoImpl();
    @Override
    public Cart findByGoodsIdAndUser(int gid, int uid) {
        return cartDao.findByGoodsIdAndUser(gid,uid);
    }

    @Override
    public void add(Cart cart) {
        cartDao.add(cart);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
