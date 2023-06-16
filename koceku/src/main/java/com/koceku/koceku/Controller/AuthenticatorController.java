package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AuthenticatorController {

    @Autowired
    UserService userService;

    @Autowired
    EwalletRepository ewalletRepo;

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
            // model.addAttribute("gagalEmail", false);
            model.addAttribute("Email", email);
            String password = "";
            model.addAttribute("Password", password);
            // model.addAttribute("gagalPass", false);
            return "signin";
        }

    }

    @PostMapping("/signin")
    public String trySignin(@RequestParam("email") String email, @RequestParam("password") String password,
            HttpServletRequest request, Model model) {
        User user = userService.findUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user); // Simpan user ke dalam session.
            return "redirect:/dashboard"; // Redirect langsung ke dashboard setelah berhasil sign-in.
        } else {
            // model.addAttribute("gagalEmail", true);
            // model.addAttribute("gagalPass",true);
            return "redirect:/signin";
        }
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPage(@ModelAttribute("user") User user) {
        // if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
        // user.getEmail().isEmpty()
        // || user.getPassword().isEmpty()) {
        // return "signup";
        // }

        // String phoneNumber = user.getPhoneNumber();
        // if (phoneNumber.isEmpty() || (!phoneNumber.startsWith("08") &&
        // !phoneNumber.startsWith("+62"))
        // || phoneNumber.length() >= 14) {
        // return "signup";
        // }

        // if (phoneNumber.startsWith("08")) {
        // phoneNumber = "+628" + phoneNumber.substring(2);
        // user.setPhoneNumber(phoneNumber);
        // }

        user.setFirstName(user.getFirstName().toUpperCase());
        user.setLastName(user.getLastName().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());

        Ewallet wallet = new Ewallet();
        user.setEwallet(wallet);
        wallet.setUser(user);
        userService.SignUp(user);
        ewalletRepo.save(wallet);
        System.out.println(user.toString());
        return "redirect:/signin";
    }

}
