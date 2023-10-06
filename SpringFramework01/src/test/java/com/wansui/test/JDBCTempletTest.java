package com.wansui.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.wansui.controller.StudentController;
import com.wansui.springIOC.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/6 18:15
 */
public class JDBCTempletTest {
    @Test
    public void test(){
        //1.创建连接池
        DruidDataSource druidDataSource = new DruidDataSource();
        //2.设置数据库地址
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        //3.设置驱动
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //4.设置账号和密码
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");

        //5.设置jdbcTemplet
        JdbcTemplate template = new JdbcTemplate();
        //6.设置数据源
        template.setDataSource(druidDataSource);
        //7.操作数据
//        template.update("");//DDL DML DCL
//        template.query("");//查询语句
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?);";
        int rows = template.update(sql, "111","小米", "男", "15", "三年三班");
        System.out.println(rows);
    }

    @Test
    public void testForIoc(){
        //1.创建容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring01.xml");
        //2.获取组件
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        //3.操作数据库

        //插入数据
//        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?);";
//        int rows = jdbcTemplate.update(sql, "112","小米", "男", "15", "三年三班");
//        System.out.println(rows);
        //查询数据

        String sql1 = "select * from students";
        //方式一手动对应
        List<Student> query = jdbcTemplate.query(sql1, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        });

        System.out.println(query);


    }

    @Test
    public void jdbcQuery() {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring01.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        //方式二自带匹配Bean类
        String querysql = "Select id, name, gender,age, class as classes from students";
        List<Student> studentList = jdbcTemplate.query(querysql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println(studentList);

    }
    @Test
    public void testStudentController(){
        //1、创建IOC容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring02.xml");
        //2、获取组件

        StudentController bean = context.getBean(StudentController.class);
        //3.调用组件
        bean.getStudents();

        //4、关闭容器

        context.close();

    }
}
