package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {

    @GetMapping("/homepage")
    public String homepage(Model model) {
        return "homepage";
    }

    @GetMapping("/payment")
    public String payment(Model model) {
        return "payment";
    }

    @GetMapping("/dashboard")
    public String Dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

    @GetMapping("/transfer")
    public String Transfer(Model model) {
        return "transfer";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        return "login";
    }

    @GetMapping("/signup")
    public String Signup(Model model) {
        return "signup";
    }
}
