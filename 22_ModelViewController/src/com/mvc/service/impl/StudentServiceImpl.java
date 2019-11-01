package com.mvc.service.impl;

import com.mvc.dao.StudentDao;
import com.mvc.dao.impl.StudentDaoImpl;
import com.mvc.domain.PageBean;
import com.mvc.domain.Student;
import com.mvc.service.StudentService;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 10/30/2019 3:50 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public PageBean<Student> findByPage(Integer pageNum, Integer pageSize) {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> data = studentDao.findByPage(pageNum, pageSize);
        long totalDataSize = studentDao.getCount();

        PageBean<Student> pageBean = new PageBean<>(pageNum, pageSize, totalDataSize, data);

        return pageBean;
    }
}
