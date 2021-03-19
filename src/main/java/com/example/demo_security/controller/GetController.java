package com.example.demo_security.controller;

import com.example.demo_security.model.AppUser;
import com.example.demo_security.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class GetController {
    @Autowired
    private IAppUserService appUserService;

    @ModelAttribute("user")
    public AppUser getCurrentUser() {
        return appUserService.getCurrentUser();
    }

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

    @PostMapping("/post")
    public String showPost() {
        return "Do POST run!";
    }

    @PutMapping("/put")
    public String showPut() {
        return "Do GET run!";
    }

    @DeleteMapping("/delete")
    public String showDelete() {
        return "Do DELETE run!";
    }

    @RequestMapping("/denied-access")
    public String deniedAccess() {
        return "Access Denied!";
    }
}
