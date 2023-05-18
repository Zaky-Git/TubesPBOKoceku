package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    
    @GetMapping("/homepage")
    public String homepage(Model model){
        return "homepage";
    }
}