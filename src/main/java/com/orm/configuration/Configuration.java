package com.orm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @Author: Administrator
 * @Date: 2019/10/25 :13:20
 * @Description:
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Profile("development")
    @Bean("H2DataSource")
    public DataSource H2DataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:create_bd_table.sql").addScript("classpath:gddn_init.sql").build();
    }


    public DataSource HikariDataSource(){

        return null;
    }
}
