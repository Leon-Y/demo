package com.example.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: Xiao
 * @Date: 2019/5/7 :20:20
 * @Description:
 */
@SpringBootConfiguration
public class HikariDataSourceBean {

    @Bean("HikariDataSourceBean")
    public DataSource getHikariDataSourceBean(
            @Value("${spring.datasource.driver-class-name}")String driver,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password
    ){
        DataSource hikariDatasource = DataSourceBuilder.create().driverClassName(driver).url(url).username(username).password(password).build();
//        HikariDataSource hikariDataSource = new HikariDataSource();
//        hikariDataSource.setDriverClassName(driver);
//        hikariDataSource.setUsername(username);
//        hikariDataSource.setPassword(password);
//        hikariDataSource.setJdbcUrl(url);

        return hikariDatasource;
    }
}
