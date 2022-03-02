package com.example.restapitest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping("/")
    public String getRoot() {
        return "In root";
    }

    @RequestMapping("/part")
    public String getPart() {
        System.out.println("IN PARTTT......................");
        return "In getPart";
    }
}
