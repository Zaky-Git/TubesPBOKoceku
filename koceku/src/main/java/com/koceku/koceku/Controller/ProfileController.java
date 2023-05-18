package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }
}
