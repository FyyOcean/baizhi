package com.baizhi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

@Configuration
public class BeansConfig {
    @Bean
    public Calendar getCalendar(){
        return Calendar.getInstance();
    }
    @Bean
    @Scope("prototype")
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        return connection;
    }

}
