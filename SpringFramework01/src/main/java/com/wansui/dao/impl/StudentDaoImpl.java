package com.wansui.dao.impl;

import com.wansui.dao.StudentDao;
import com.wansui.springIOC.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/6 22:04
 */
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Student> queryAll() {
        String querySql = "Select id, name, gender,age, class as classes from students";

        return jdbcTemplate.query(querySql, new BeanPropertyRowMapper<>(Student.class));
    }
}
