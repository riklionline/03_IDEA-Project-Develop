package com.mvc.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: DataSourceUtils
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 10/30/2019 10:59 AM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class DataSourceUtils {
    private static DruidDataSource dataSource;
    static {
        Properties properties = new Properties();
        InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Initialize database failure!");
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
