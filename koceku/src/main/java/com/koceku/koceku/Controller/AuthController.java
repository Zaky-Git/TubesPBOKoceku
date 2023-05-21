package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.UserRepository;

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

    private UserRepository userRepository;

    @PostMapping("/signup")
    public String SignupUser(@ModelAttribute("user") User user) {
        Ewallet wallet = new Ewallet();
        User user1 = new User(user.getNama(), user.getEmail(), user.getPhoneNumber(), user.getPassword(), wallet);
        userRepository.save(user1);
        return "redirect:/";
    }

}
