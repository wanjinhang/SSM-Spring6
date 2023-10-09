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
    Student seleteStudent(Integer studentId);

    int insertStudent(Student student);
}
