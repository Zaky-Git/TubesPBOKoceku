package com.koceku.koceku.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koceku.koceku.Model.Ewallet;
import com.koceku.koceku.Model.Transaction;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.EwalletRepository;
import com.koceku.koceku.Repository.TransactionRepository;
import com.koceku.koceku.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TransferController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    EwalletRepository ewalletRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transfer")
    public String Transfer(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("nominal", (double) 0);
            model.addAttribute("nohp", "");
            List<Transaction> transactionHistory = transactionRepository.findByEwalletIdAndMethod(
                    user.getEwallet().getId(),
                    "Transfer");
            if (transactionHistory != null) {
                Collections.reverse(transactionHistory);
                transactionHistory.removeIf(t -> t.getType().contains("Income"));
                model.addAttribute("transactions", transactionHistory);
            } else {
                model.addAttribute("noHistory", true);
            }
            return "transfer";
        }
        return "/signin";

    }

    @PostMapping("/transfer")
    public String transferMethod(Model model, @RequestParam("nominal") Double nominal,
            @RequestParam("nohp") String nohp, @RequestParam("note") String note, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String phoneNumber = nohp;
        double uangTransfer = nominal;
        if (user != null) {
            if (user.getEwallet().getBalance() >= uangTransfer) {
                User user2 = userRepo.findByPhoneNumber(phoneNumber);
                if (user2 != null) {
                    Ewallet userEwallet = user.getEwallet();
                    Ewallet recipientEwallet = userEwallet.transfer(uangTransfer, user2.getEwallet(),
                            note, "Koceku");
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
