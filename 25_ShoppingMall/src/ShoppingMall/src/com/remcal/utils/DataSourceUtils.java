package com.remcal.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class DataSourceUtils {
    private static DruidDataSource dataSource;
    static{
        try {
            Properties properties=new Properties();
            InputStream is=DataSourceUtils.class.getClassLoader().getResourceAsStream("database.properties");
            properties.load(is);

            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接池初始化失败");
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}
