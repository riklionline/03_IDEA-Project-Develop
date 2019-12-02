package com.remcal.dao.impl;

import com.remcal.dao.CartDao;
import com.remcal.domain.Cart;
import com.remcal.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @ClassName: test
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 11/11/2019 6:26 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */

public class CartDaoImpl implements CartDao {
    @Override
    public Cart findByGoodsIdAndUser(int gid, int uid) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Cart rs= qr.query("select * from tb_cart where id=? and pid=?", new BeanHandler<>(Cart.class), uid, gid);
            System.out.println(rs);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public void add(Cart cart) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Object[] params={cart.getId(),cart.getPid(),cart.getNum(),cart.getMoney()};
            qr.update("insert into tb_cart(id,pid,num,money) values(?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加购物车失败");
        }
    }

    @Override
    public void update(Cart cart) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Object[] params={cart.getNum(),cart.getMoney(),cart.getId(),cart.getPid()};
            qr.update("update tb_cart set num=?,money=? where id=? and pid=?",params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("更新购物车失败");
        }
    }
}
