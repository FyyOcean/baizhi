package com.baizhi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl2 implements HelloService{
    @Override
    public void hello(String name) {
        System.out.println("Hello service2"+name);
    }
}
