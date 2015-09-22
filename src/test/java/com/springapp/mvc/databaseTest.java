package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.DriverManager;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by NS on 2015/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/resources/config/spring/spring-datasource.xml")
public class databaseTest {

    private static Connection con = null;

    public static void main(String args[]) throws Exception{

        ApplicationContext ctx=new ClassPathXmlApplicationContext("file:src/main/resources/config/spring/spring-datasource.xml");

        DataSource dataSource=(ProxoolDataSource)ctx.getBean("dataSource_proxool",DataSource.class);

        String sql="select * from user";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (Exception e){
            System.out.println("--- connection fail -----");
            e.printStackTrace();
        }

        if(connection == null){
            System.out.println("connection is null");
            return;
        }
        Statement stm=connection.createStatement();

        ResultSet rs=stm.executeQuery(sql);

        while(rs.next()) {
            System.out.print("用户名是:");

            System.out.println(rs.getString(2));

        }

    }
}
