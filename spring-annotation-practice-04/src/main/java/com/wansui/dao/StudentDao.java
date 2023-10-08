package com.wansui.dao;

import com.wansui.pojos.Student;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 19:51
 */
//接口
public interface StudentDao {

    /**
     * 查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}
