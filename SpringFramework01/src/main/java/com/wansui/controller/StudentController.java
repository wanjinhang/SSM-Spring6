package com.wansui.controller;

import com.wansui.server.StudentService;
import com.wansui.springIOC.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/6 22:15
 */
public class StudentController {
    private StudentService  studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void getStudents(){

        List<Student> all = studentService.findAll();
        System.out.println(all);

    }
}
