package com.orm;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: Administrator
 * @Date: 2019/10/25 :11:24
 * @Description:
 */
public class testJDBCTemplate {
    public static void main(String[] args) {
        JdbcTemplateAutoConfiguration jdbcTemplateAutoConfiguration = new JdbcTemplateAutoConfiguration();
        new JdbcTemplate();
    }
}
