package com.wansui.server.impl;

import com.wansui.dao.impl.StudentDaoImpl;
import com.wansui.server.StudentService;
import com.wansui.springIOC.Student;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/6 22:12
 */
public class StudentServiceImpl implements StudentService {
    private StudentDaoImpl studentDao;

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }
    @Override
    public List<Student> findAll() {

        return studentDao.queryAll();
    }
}
