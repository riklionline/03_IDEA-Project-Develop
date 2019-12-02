package com.remcal.dao.impl;

import com.remcal.dao.GoodsTypeDao;
import com.remcal.domain.GoodsType;
import com.remcal.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> findByLevel(int level) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods_type where level=?", new BeanListHandler<>(GoodsType.class),level);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException("查询商品类别失败");
        }
    }

    @Override
    public GoodsType findById(Integer typeId) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods_type where id=?", new BeanHandler<>(GoodsType.class),typeId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException("查询id查询商品类别失败");
        }
    }
}
