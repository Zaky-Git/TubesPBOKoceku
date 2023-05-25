package com.koceku.koceku.Controller;

import java.lang.ProcessBuilder.Redirect;

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
public class authenticationController {

    @Autowired
    UserService userService;

    @Autowired
    EwalletRepository ewalletRepo;

    @PostMapping("/signin")
    public String trySignin(@RequestParam("email") String email, @RequestParam("password") String password,
            Model model, HttpServletRequest request) {
        User user = userService.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user); // Simpan user ke dalam session
            return "redirect:/dashboard"; // Redirect langsung ke dashboard setelah berhasil sign-in
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/logout")
    public String Logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/signin";
    }

    @GetMapping("/signin")
    public String signinPage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            return "redirect:/dashboard";
        } else {
            String email = "";
            model.addAttribute("Email", email);
            String password = "";
            model.addAttribute("Password", password);
            return "signin";
        }

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
        return "redirect:/signin";
    }
}
