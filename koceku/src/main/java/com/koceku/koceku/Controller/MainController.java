package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    EwalletRepository ewalletRepo;

    @Autowired
    EwalletRepository transactionRepo;

    @GetMapping("/")
    public String homepage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("Login", true);
        } else {
            model.addAttribute("Login", false);
        }
        return "homepage";
    }

    @GetMapping("/aboutus")
    public String aboutus(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("Login", true);
        } else {
            model.addAttribute("Login", false);
        }
        return "aboutus";
    }

    @GetMapping("/contactus")
    public String contactus(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("Login", true);
        } else {
            model.addAttribute("Login", false);
        }
        return "contactus";
    }

    @GetMapping("/listFunction")
    public String listFunction(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("Login", true);
        } else {
            model.addAttribute("Login", false);
        }
        return "function";
    }

}
