package com.koceku.koceku.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koceku.koceku.Model.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TransferController {
    @GetMapping("/transfer")
    public String Transfer(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "transfer";
    }
}
