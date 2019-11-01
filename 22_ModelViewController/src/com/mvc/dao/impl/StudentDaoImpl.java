package com.mvc.dao.impl;

import com.mvc.dao.StudentDao;
import com.mvc.domain.Student;
import com.mvc.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName: StudentDaoImpl
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 10/30/2019 3:24 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findByPage(Integer pageNum, Integer pageSize) {

        try {
            QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
            return qr.query("select * from student order by studentNo limit ?,?", new BeanListHandler<Student>(Student.class), (pageNum - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getCount() {

        try {
            QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
            return qr.query("select count(*) from student", new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void add(Student student) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        try {
            Object[] params = {student.getStudentNo(),student.getLoginPwd(),student.getStudentName(),student.getSex(),student.getBornDate()};
            qr.update("insert into student value(?,?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
