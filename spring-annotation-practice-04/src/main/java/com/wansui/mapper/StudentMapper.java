package com.wansui.mapper;

import com.wansui.pojos.Student;

/**
 * @author wansui
 * @date 2023/10/09
 */
public interface StudentMapper {

    /**
     * 根据学生Id查找学生信息
     *
     * @param studentId
     * @return {@link Student}
     */
    Student selectStudent(Integer studentId);
    //插入学生
    int insertStudent(Student student);
    //删除学生
    int deleteStudent(Integer studentId);
    //查找班级人员
    Student selectStudentByClasses(String classes);
    //修改学生信息
    int updateStudentById(Student student);
}
