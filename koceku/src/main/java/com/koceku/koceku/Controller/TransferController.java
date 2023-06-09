package com.koceku.koceku.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TransferController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    EwalletRepository ewalletRepository;

    @GetMapping("/transfer")
    public String Transfer(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("nominal", (double) 0);
        model.addAttribute("nohp", "");
        if (user != null) {
            return "transfer";
        }
        return "/signin";

    }

    // TransferController.java

    @PostMapping("/transfer")
    public String transferMethod(Model model, @RequestParam("nominal") Double nominal,
            @RequestParam("nohp") String nohp, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String phoneNumber = nohp;
        double uangTransfer = nominal;
        if (user != null) {
            if (user.getEwallet().getBalance() >= uangTransfer) {
                User user2 = userRepo.findByPhoneNumber(phoneNumber);
                if (user2 != null) {
                    Ewallet userEwallet = user.getEwallet();
                    Ewallet recipientEwallet = userEwallet.transfer(uangTransfer, user2.getEwallet(),
                            "Transfer note", "Koceku");
                    if (recipientEwallet != null) {
                        ewalletRepository.save(userEwallet);
                        userEwallet.resetTransactions();
                        ewalletRepository.save(recipientEwallet);
                        recipientEwallet.resetTransactions();
                        return "redirect:/transfer";
                    } else {
                        return "/transfer";
                    }
                } else {
                    return "/transfer";
                }
            } else {
                return "redirect:/transfer";
            }
        }
        return "/signin";
    }

}
