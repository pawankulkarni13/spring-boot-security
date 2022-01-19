package com.stark.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeResource {

    @GetMapping("/")
    public String home() {
        return ("Welcome Home !!!");
    }

    @GetMapping("/user")
    public String user() {
        return ("Welcome User !!!");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("Welcome Admin !!!");
    }
}
