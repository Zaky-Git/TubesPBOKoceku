package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Service.UserService;

import org.springframework.ui.Model;

@Controller
public class AuthController {

    @GetMapping("/")
    public String SigninPage(Model model) {
        return "signin";
    }

    @GetMapping("/signup")
    public String SignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    UserService service;

    @PostMapping("/signup")
    public String SignupPage(@ModelAttribute("user") User u) {
        System.out.println(u.toString());
        service.SignUp(u);
        return "redirect:/";
    }
}
