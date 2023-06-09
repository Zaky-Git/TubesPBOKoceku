package com.koceku.koceku.Controller;

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

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PaymentController {

    @Autowired
    EwalletRepository ewalletRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/payment")
    public String payment(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            String tagihan = "";
            model.addAttribute("tagihan", tagihan);
            String nomorTagihan = "";
            model.addAttribute("nomorTagihan", nomorTagihan);
            String nominal = "";
            model.addAttribute("nominal", nominal);
            List<Transaction> transactionPaymentHistory = transactionRepository
                    .findByEwalletIdAndMethod(user.getEwallet().getId(), "Payment");
            model.addAttribute("listTransactionPayment", transactionPaymentHistory);
            System.out.println(transactionPaymentHistory);
            return "payment";
        } else {
            return "redirect:/signin";
        }
    }

    @PostMapping("/payment")
    public String payment(Model model, HttpServletRequest request,
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
                return "redirect:/payment";
            } else {
                wallet.topUp(amountNoMoneyFormat, phoneNumber, note, ewallet, "Failed");
                ewalletRepository.save(wallet);
                wallet.resetTransactions();
                model.addAttribute("insuficientBalance", "insuficientBalance");
                return "redirect:/payment";
            }
        } else if (user != null && phoneNumber == "") {
            return "redirect:/topup";
        } else {
            return "redirect:/signin";
        }
    }

}
