package com.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: Administrator
 * @Date: 2019/10/25 :14:02
 * @Description:
 */
@Controller
@RequestMapping("/test")
public class DataSourceTest {

    @Autowired
    private DataSource H2DataSource;

    @RequestMapping(value = "/top",method = RequestMethod.POST)
    public String testDatasource(){
        try {
            Connection connection = H2DataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T extends String> void Generic(){

    }
}
