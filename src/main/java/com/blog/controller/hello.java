package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class hello {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}
