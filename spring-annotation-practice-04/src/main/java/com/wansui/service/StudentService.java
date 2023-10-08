package com.wansui.service;

import com.wansui.pojos.Student;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 19:55
 */
//接口
public interface StudentService {

    /**
     * 查询全部学员业务
     * @return
     */
    List<Student> findAll();

}