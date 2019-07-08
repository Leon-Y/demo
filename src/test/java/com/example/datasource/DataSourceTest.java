package com.example.datasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Xiao
 * @Date: 2019/5/7 :20:10
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HikariDataSourceBean.class})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() {
        System.out.println(dataSource);
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from zhgd_user");
            System.out.println(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
