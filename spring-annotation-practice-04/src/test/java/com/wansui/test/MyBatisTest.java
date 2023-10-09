package com.wansui.test;

import com.wansui.mapper.StudentMapper;
import com.wansui.pojos.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testSelectStudent() throws IOException {
        //1、创建SqlSessionFactory对象
        //声明Mybatis全局配置文件的路径

        String mybatisConfigPath ="mybatis-config.xml";
        // 以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigPath);
        //基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、使用SqlSessionFactory对象开启一个会话

        SqlSession sqlSession = factory.openSession();
        //3、根据StudentMapper接口的class对象获取Mapper接口类型的对象

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //调用代理类方法既可以触发对应的Sql语句
        Student student = studentMapper.seleteStudent(1);
        System.out.println("student = " + student);
        //提交事物
        sqlSession.commit();
        //关闭会话
        sqlSession.close();




    }

    @Test
    public void test2() throws IOException {
        //
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        Student student = mapper.seleteStudent(2);
//        System.out.println("student = " + student);
        Student student = new Student();
        student.setId(111);
        student.setName("wansui");
        student.setGender("男");
        student.setAge(18);
        student.setClasses("java");
        int i = mapper.insertStudent(student);
        System.out.println("i = " + i);
        sqlSession.commit();
        sqlSession.close();
    }
}
