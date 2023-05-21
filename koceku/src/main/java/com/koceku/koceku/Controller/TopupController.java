package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class TopupController {

    @GetMapping("/topup")
    public String topup(Model model) {
        return "topup";
    }
}
