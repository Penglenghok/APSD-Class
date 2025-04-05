package com.pengleng.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/home","library"})
    public String homePage(){
        return "home/index";
    }

}
