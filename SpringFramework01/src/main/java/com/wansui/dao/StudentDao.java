package com.wansui.dao;

import com.wansui.springIOC.Student;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/6 22:00
 */
public interface StudentDao {

    List<Student> queryAll();
}
