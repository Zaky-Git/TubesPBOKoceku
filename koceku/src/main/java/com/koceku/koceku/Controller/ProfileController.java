package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Repository.UserRepository;
import com.koceku.koceku.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute(user);
            model.addAttribute("firstName", "");
            model.addAttribute("lastName", "");
            model.addAttribute("email", "");
            model.addAttribute("phoneNumber", "");
            model.addAttribute("password", "");
            model.addAttribute("passwordConfirmation", "");
            return "profile";
        } else {
            return "redirect:/signin";
        }
    }

    @PostMapping("/editProfile")
    public String editProfile(Model model, HttpServletRequest request, @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName, @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber, @RequestParam("password") String password,
            @RequestParam("passwordConfirmation") String passwordConfirmation) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPhoneNumber(phoneNumber);
                userRepository.save(user);
                return "redirect:/profile";
            
        } else {
            return "redirect:/signin";
        }
    }
}