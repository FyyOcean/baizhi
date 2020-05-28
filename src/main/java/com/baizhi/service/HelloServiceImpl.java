package com.baizhi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void hello(String name) {
        System.out.println("hello service:"+ name);
    }
}
