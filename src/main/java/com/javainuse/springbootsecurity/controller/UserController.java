package com.javainuse.springbootsecurity.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @RequestMapping("/")
    public String getUsers()
    {
        return "Hello User";
    }

}
