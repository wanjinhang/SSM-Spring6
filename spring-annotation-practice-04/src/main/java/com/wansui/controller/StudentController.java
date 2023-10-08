package com.wansui.controller;

import com.wansui.pojos.Student;
import com.wansui.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 19:59
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void getStudents() {
        List<Student> all = studentService.findAll();
        System.out.println(all);

    }
}
