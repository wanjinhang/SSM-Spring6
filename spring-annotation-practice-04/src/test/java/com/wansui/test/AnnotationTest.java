package com.wansui.test;

import com.wansui.config.JavaConfig;
import com.wansui.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 20:44
 */
@SpringJUnitConfig(value = {JavaConfig.class})
public class AnnotationTest {
    @Autowired
    private StudentController   studentController;
    @Test
    public void test(){
        studentController.getStudents();
    }
}
