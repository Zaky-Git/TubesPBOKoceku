package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Repository.UserRepository;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    EwalletRepository ewalletRepo;

    @Autowired
    EwalletRepository transactionRepo;

    @GetMapping("/homepage")
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
    public String Dashboard(Model model) {
        // User user1 = new User("Stiv", "Rangga", "udin@gmail.com", "08272121",
        // "makanenak", new Ewallet());
        // model.addAttribute("balance", user1.getEwallet().getBalance());
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

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
        return "aboutus";
    }

    @GetMapping("/contactus")
    public String contactus(Model model) {
        return "contactus";
    }

    @GetMapping("/")
    public String signinPage(Model model) {
        return "signin";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPage(@ModelAttribute("user") User user) {
        Ewallet wallet = new Ewallet();
        user.setEwallet(wallet);
        userRepo.save(user);
        ewalletRepo.save(wallet);
        System.out.println(user.toString());
        return "redirect:/";
    }

}

