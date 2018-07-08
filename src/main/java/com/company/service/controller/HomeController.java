package com.company.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showMainPage(){
        return "Home";
    }
//
//    @GetMapping("/login")
//    public String login(){return "Login";}

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/LoginError")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
