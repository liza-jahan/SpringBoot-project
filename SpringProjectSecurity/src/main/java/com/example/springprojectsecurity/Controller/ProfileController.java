package com.example.springprojectsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("profile")
public class ProfileController {

    @GetMapping("index")
    public String index(){
        return "profile/index";
    }}
