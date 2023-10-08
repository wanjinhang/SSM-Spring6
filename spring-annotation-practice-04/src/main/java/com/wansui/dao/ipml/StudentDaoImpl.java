package com.wansui.dao.ipml;

import com.wansui.dao.StudentDao;
import com.wansui.pojos.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 19:52
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> queryAll() {
        String querySql = "Select id, name, gender,age, class as classes from students";

        return jdbcTemplate.query(querySql, new BeanPropertyRowMapper<>(Student.class));
    }
}
