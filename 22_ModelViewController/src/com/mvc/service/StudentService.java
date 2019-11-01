package com.mvc.service;

import com.mvc.domain.PageBean;
import com.mvc.domain.Student;

/**
 * @InterfaceName: StudentService
 * @Descirption: 核心业务代码
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 10/30/2019 3:39 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
public interface StudentService {
    PageBean<Student> findByPage(Integer pageNum, Integer pageSize);//

}
