package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController//localhost:8989/hello/hello //所有方法全转json
//springboot项目默认没有访问名
@RequestMapping("hello")
public class HelloController {
    @Value("${names}")
    private String name;
    @Value("${server.port}")
    private String port;
    @Value("${price}")
    private Double price;
    @Value("${age}")
    private Integer age;
    @Value("${qqs}")
    private String[] qqs;
    @Value("#{'${strs}'.split(',')}")
    private List<String> strs;
    @Value("#{${maps}}")
    private Map<String,String> maps;
    @Autowired
    private User user;
    @Autowired
    @Qualifier("helloServiceImpl2")
    private  HelloService helloService;
    @Autowired
    private Calendar calender;
    @Autowired
    private Connection connection;
    @Autowired
    private Connection connection1;

    @RequestMapping("hello")
    //string 代表视图跳转,默认不支持jsp视图
    public String hello(){
        System.out.println("姓名: "+name);
        System.out.println("server.port:"+port);
        System.out.println("年龄:"+age);
        System.out.println("价格:"+price);
        for (String qq : qqs) {
            System.out.println(qq);
        }
        System.out.println("遍历List集合");
        strs.forEach(str -> System.out.println(str));
        System.out.println("遍历map");
        maps.forEach((k,v) -> System.out.println("key:"+k+"value:"+v));
        System.out.println("user: "+user);
        System.out.println("user中map ");
        user.getMaps().forEach((k,v)-> System.out.println("userkey:"+k+"uservalue:"+v));
        helloService.hello("springboot_haha");
        System.out.println("Calendar: "+calender.getTime());
        System.out.println("Connection :"+connection);
        System.out.println("Connection :"+connection1);
        System.out.println("hello springboot");
        return "hello springboot";
    }

    @RequestMapping("hello1")
    //string 代表视图跳转,默认不支持jsp视图
    public String hello1(){
        System.out.println("hello1 springboot");
        return "hello1 springboot";
    }
    @RequestMapping("hello2")
    //string 代表视图跳转,默认不支持jsp视图
    public String hello2(){
        System.out.println("hello2 springboot");
        return "hello2 springboot";
    }
}
