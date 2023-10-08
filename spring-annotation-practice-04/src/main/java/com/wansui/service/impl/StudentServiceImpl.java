package com.wansui.service.impl;

import com.wansui.dao.StudentDao;
import com.wansui.pojos.Student;
import com.wansui.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 19:58
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        return studentDao.queryAll();
    }
}
