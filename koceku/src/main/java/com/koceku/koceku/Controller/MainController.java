package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Repository.UserRepository;
import com.koceku.koceku.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    EwalletRepository ewalletRepo;

    @Autowired
    EwalletRepository transactionRepo;

    @GetMapping("/")
    public String homepage(Model model) {

        return "homepage";
    }

    @GetMapping("/payment")
    public String payment(Model model) {
        return "payment";
    }

    @GetMapping("/topup")
    public String topup(Model model) {
        return "topup";
    }

    @GetMapping("/dashboard")
    public String Dashboard(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        return "profile";
    }

    @GetMapping("/transfer")
    public String Transfer(Model model) {
        return "transfer";
    }

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
        return "aboutus";
    }

}
