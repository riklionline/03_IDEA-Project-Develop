package com.mvc.sqlbuild;

import com.mvc.dao.impl.StudentDaoImpl;
import com.mvc.domain.Student;

import java.util.Date;

/**
 * @ClassName: SQLBuild
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 11/1/2019 10:33 AM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class SQLBuild {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();

        for (int i = 1; i < 500; i++) {
            Student student = new Student(i, "123456789", "李连盟_00" + i, "男", new Date());
            studentDao.add(student);
        }
    }
}
