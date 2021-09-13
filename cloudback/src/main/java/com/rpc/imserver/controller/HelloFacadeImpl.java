package com.rpc.imserver.controller;


import com.rpc.spring.annotation.MyServierI;

@MyServierI(serviceInterface = HelloFacade.class, serviceVersion = "1.0.0")
public class HelloFacadeImpl implements HelloFacade {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
