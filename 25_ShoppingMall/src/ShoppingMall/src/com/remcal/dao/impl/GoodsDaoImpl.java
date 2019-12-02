package com.remcal.dao.impl;

import com.remcal.dao.GoodsDao;
import com.remcal.domain.Goods;
import com.remcal.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: test
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 11/11/2019 6:26 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public long getCount(String condition) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select count(*) from tb_goods";
        if(condition!=null){
            sql+= " where "+condition;
        }
        try {
            return (long) qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Goods> findByWhere(int pageN, int pageS, String condition) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from tb_goods";
        if(condition!=null){
            sql+= " where "+condition;
        }
        sql+=" order by id limit ?,?";
        try {
            return  qr.query(sql,new BeanListHandler<>(Goods.class),(pageN-1)*pageS,pageS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;

    }

    @Override
    public Goods findById(int gid) {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        try {
            return qr.query("select * from tb_goods where id=?", new BeanHandler<>(Goods.class),gid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
