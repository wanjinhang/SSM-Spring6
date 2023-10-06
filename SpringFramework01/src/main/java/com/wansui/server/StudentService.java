package com.wansui.server;

import com.wansui.springIOC.Student;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/6 22:10
 */
public interface StudentService {

    List<Student> findAll();
}
