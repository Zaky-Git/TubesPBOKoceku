package com.koceku.koceku.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Parameter;
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

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TopupController {

    @Autowired
    EwalletRepository ewalletRepository;

    @Autowired
    TransactionRepository transactionRepository;

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
            String note = "";
            model.addAttribute("note", note);
            List<Transaction> transactionTopupHistory = transactionRepository
                    .findByEwalletIdAndMethod(user.getEwallet().getId(), "Top Up");
            model.addAttribute("listTransactionTopup", transactionTopupHistory);
            System.out.println(transactionTopupHistory);
            return "topup";
        } else {
            return "redirect:/signin";
        }
    }

    @PostMapping("/topup")
    public String topup(Model model, HttpServletRequest request,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("ewallet") String ewallet,
            @RequestParam("amount") String amount, @RequestParam("note") String note) {
        User user = (User) request.getSession().getAttribute("user");
        double amountNoMoneyFormat = Double.parseDouble(amount.replace("Rp", "").replace(",", ""));
        if (user != null && phoneNumber != "") {
            Ewallet wallet = user.getEwallet();
            if (wallet.getBalance() >= amountNoMoneyFormat) {
                model.addAttribute("user", user);
                wallet.topUp(amountNoMoneyFormat, phoneNumber, note, ewallet, "Success");
                ewalletRepository.save(wallet);
                wallet.resetTransactions();
                return "redirect:/topup";
            } else {
                wallet.topUp(amountNoMoneyFormat, phoneNumber, note, ewallet, "Failed");
                ewalletRepository.save(wallet);
                wallet.resetTransactions();
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