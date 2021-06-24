package com.rpc.imclient.controller;

import com.rpc.db.entity.User;
import com.rpc.db.reposity.UserRepository;
import com.rpc.imserver.controller.HelloFacade;
import com.rpc.spring.annotation.MyReferenceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Scope("session")
public class HelloController {
    @Autowired
    private UserRepository userRepository;
    @SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection", "SpringJavaInjectionPointsAutowiringInspection"})
    @MyReferenceI(serviceVersion = "1.0.0", timeout = 30000)
    private HelloFacade helloFacade;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return helloFacade.hello("mini rpc");
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public void addUser(){

        User user = userRepository.save(User.builder().name("jackxx").email("123456@126.com").build());
        List<User> users= userRepository.findAll();
        System.out.println(users);
    }
}
