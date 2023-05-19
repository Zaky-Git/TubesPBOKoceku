package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.koceku.koceku.Model.*;

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
        User user1 = new User("Stiv", "udin@gmail.com", "08272121", new Ewallet());
        model.addAttribute("balance", user1.getEwallet().getBalance());
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
