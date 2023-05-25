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

@Controller
public class MainController {

    @Autowired
    UserService userService;

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

    @PostMapping("/signin")
    public String trySignin(@RequestParam("email") String email, @RequestParam("password") String password,
            Model model, HttpServletRequest request) {
        User user = userService.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user); // Simpan user ke dalam session
            return "redirect:/dashboard"; // Redirect langsung ke dashboard setelah berhasil sign-in
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/dashboard")
    public String Dashboard(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "dashboard";
        } else {
            return "redirect:/";
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

    @GetMapping("/")
    public String signinPage(Model model) {
        String email = "";
        model.addAttribute("Email", email);
        String password = "";
        model.addAttribute("Password", password);
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
        userService.SignUp(user);
        ewalletRepo.save(wallet);
        System.out.println(user.toString());
        return "redirect:/";
    }

}
