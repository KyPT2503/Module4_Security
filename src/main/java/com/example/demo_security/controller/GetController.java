package com.example.demo_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class GetController {
    @GetMapping("/home")
    public ModelAndView showIndex() {
        return new ModelAndView("index");
    }

    @GetMapping("/profile")
    public ModelAndView showProfilePage() {
        return new ModelAndView("profile");
    }

    @GetMapping("/manager")
    public ModelAndView showManagerPage() {
        return new ModelAndView("manager");
    }
}
