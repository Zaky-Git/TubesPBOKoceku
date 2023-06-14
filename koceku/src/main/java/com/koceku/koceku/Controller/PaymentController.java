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
            String nomorTagihan = "";
            model.addAttribute("nomorTagihan", nomorTagihan);
            String amount = "";
            model.addAttribute("amount", amount);
            String paymentType = "";
            model.addAttribute("paymentType", paymentType);
            List<Transaction> transactionPaymentHistory = transactionRepository
                    .findByEwalletIdAndMethod(user.getEwallet().getId(), "Payment");
            Collections.reverse(transactionPaymentHistory);
            model.addAttribute("listTransactionPayment", transactionPaymentHistory);
            System.out.println(transactionPaymentHistory);
            return "payment";
        } else {
            return "redirect:/signin";
        }
    }

    @PostMapping("/payment")
    public String payment(Model model, HttpServletRequest request,
            @RequestParam("nomorTagihan") String nomorTagihan,
            @RequestParam("amount") String amount, @RequestParam("paymentType") String paymentType) {
        User user = (User) request.getSession().getAttribute("user");
        double amountNoMoneyFormat = Double.parseDouble(amount.replace("Rp", "").replace(",", ""));
        if (user != null && nomorTagihan != null) {
            Ewallet wallet = user.getEwallet();
            if (wallet.getBalance() >= amountNoMoneyFormat) {
                model.addAttribute("user", user);
                wallet.payment(paymentType, nomorTagihan, "Success", amountNoMoneyFormat);
                ewalletRepository.save(wallet);
                wallet.resetTransactions();
                return "redirect:/payment";
            } else {
                wallet.payment(paymentType, nomorTagihan, "Failed", amountNoMoneyFormat);
                ewalletRepository.save(wallet);
                wallet.resetTransactions();
                model.addAttribute("insuficientBalance", "insuficientBalance");
                return "redirect:/payment";
            }
        } else if (user != null && nomorTagihan == "") {
            return "redirect:/topup";
        } else {
            return "redirect:/signin";
        }
    }
}
