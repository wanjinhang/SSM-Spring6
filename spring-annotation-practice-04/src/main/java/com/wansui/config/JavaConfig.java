package com.wansui.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * IoC配置类
 * @author wansui
 * @version 1.0
 * @since 2023/10/8 20:03
 */
@ComponentScan(basePackages = "com.wansui")
@PropertySource({"classpath:jdbc.properties"})
@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driver}")
    private String  driver;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource ;

    }
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(druidDataSource);
        return jdbcTemplate;

    }
}
