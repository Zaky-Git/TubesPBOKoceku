package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaymentController {
    
    @GetMapping("/payment")
    public String payment(Model model){
        return "payment";
    }
}
