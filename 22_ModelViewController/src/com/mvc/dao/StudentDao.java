package com.mvc.dao;

import com.mvc.domain.Student;

import java.util.List;

/**
 * @InterfaceName: StudentDao
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 10/30/2019 3:20 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public interface StudentDao {
    List<Student> findByPage(Integer pageNum,Integer pageSize);//根据要查询的页码和一页显示的数据量查询
    long getCount();//获取数据总数

    void add(Student student);

}
