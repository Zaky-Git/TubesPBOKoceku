package com.koceku.koceku.Controller;

import org.hibernate.annotations.Parameter;
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
public class TopupController {

    @Autowired
    EwalletRepository ewalletRepository;

    @GetMapping("/topup")
    public String topupPage(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            String phoneNumber = "";
            model.addAttribute("phoneNumber", phoneNumber);
            String ewallet = "";
            model.addAttribute("ewallet", ewallet);
            String amount = "";
            model.addAttribute("amount", amount);
            return "topup";
        } else {
            return "redirect:/signin";
        }
    }

    @PostMapping("/topup")
    public String topup(Model model, HttpServletRequest request,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("ewallet") String ewallet,
            @RequestParam("amount") String amount) {
        User user = (User) request.getSession().getAttribute("user");
        double amountNoMoneyFormat = Double.parseDouble(amount.replace("Rp", "").replace(",", ""));
        if (user != null && phoneNumber != "") {
            Ewallet wallet = user.getEwallet();
            if (wallet.getBalance() < amountNoMoneyFormat) {
                model.addAttribute("user", user);
                wallet.topUp(amountNoMoneyFormat, phoneNumber);
                ewalletRepository.save(wallet);
                return "redirect:/topup";
            } else {
                model.addAttribute("insuficientBalance", "insuficientBalance");
                return "redirect:/topup";
            }
        } else if (user != null && phoneNumber == "") {
            return "redirect:/topup";
        } else {
            return "redirect:/signin";
        }
    }
}
