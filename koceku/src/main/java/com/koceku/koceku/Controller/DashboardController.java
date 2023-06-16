package com.koceku.koceku.Controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koceku.koceku.Model.Transaction;
import com.koceku.koceku.Model.User;
import com.koceku.koceku.Repository.TransactionRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @Autowired
    TransactionRepository transactionRepo;

    @GetMapping("/dashboard")
    public String Dashboard(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            List<Transaction> listHistory = transactionRepo.findByEwalletId(user.getEwallet().getId());
            if (listHistory.isEmpty()) {
                model.addAttribute("listHistory", listHistory);
                model.addAttribute("noHistory", (boolean) true);
                return "dashboard";
            } else {
                listHistory.removeIf(transaction -> transaction.getMethod().contains("Payment"));
                Collections.reverse(listHistory);
                model.addAttribute("noHistory", (boolean) false);
                model.addAttribute("listHistory", listHistory);
                return "dashboard";
            }
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboardSuccess")
    public String DashboardSuccess(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            List<Transaction> listHistory = transactionRepo.findByEwalletIdAndStatus(user.getEwallet().getId(),
                    "success");
            if (listHistory.isEmpty()) {
                model.addAttribute("listHistory", listHistory);
                model.addAttribute("noHistory", (boolean) true);
                return "dashboardSuccess";
            } else {
                listHistory.removeIf(transaction -> transaction.getMethod().contains("Payment"));
                Collections.reverse(listHistory);
                model.addAttribute("noHistory", (boolean) false);
                model.addAttribute("listHistory", listHistory);
                return "dashboardSuccess";
            }
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboardFailed")
    public String DashboardFailed(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            List<Transaction> listHistory = transactionRepo.findByEwalletIdAndStatus(user.getEwallet().getId(),
                    "Failed");
            if (listHistory.isEmpty()) {
                model.addAttribute("listHistory", listHistory);
                model.addAttribute("noHistory", (boolean) true);
                return "dashboardFailed";
            } else {
                listHistory.removeIf(transaction -> transaction.getMethod().contains("Payment"));
                Collections.reverse(listHistory);
                model.addAttribute("noHistory", (boolean) false);
                model.addAttribute("listHistory", listHistory);
                return "dashboardFailed";
            }
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboardIncome")
    public String DashboardIncome(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            List<Transaction> listHistory = transactionRepo.findByEwalletIdAndType(user.getEwallet().getId(), "Income");
            if (listHistory.isEmpty()) {
                model.addAttribute("listHistory", listHistory);
                model.addAttribute("noHistory", (boolean) true);
                return "dashboardIncome";
            } else {
                listHistory.removeIf(transaction -> transaction.getMethod().contains("Payment"));
                Collections.reverse(listHistory);
                model.addAttribute("noHistory", (boolean) false);
                model.addAttribute("listHistory", listHistory);
                return "dashboardIncome";
            }
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboardExpense")
    public String DashboardExpense(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            List<Transaction> listHistory = transactionRepo.findByEwalletIdAndType(user.getEwallet().getId(),
                    "Expense");
            if (listHistory.isEmpty()) {
                model.addAttribute("listHistory", listHistory);
                model.addAttribute("noHistory", (boolean) true);
                return "dashboardExpense";
            } else {
                listHistory.removeIf(transaction -> transaction.getMethod().contains("Payment"));
                Collections.reverse(listHistory);
                model.addAttribute("noHistory", (boolean) false);
                model.addAttribute("listHistory", listHistory);
                return "dashboardExpense";
            }
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/dashboardPayment")
    public String DashboardPayment(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            List<Transaction> listHistory = transactionRepo.findByEwalletIdAndMethod(user.getEwallet().getId(),
                    "Payment");
            if (listHistory.isEmpty()) {
                model.addAttribute("listHistory", listHistory);
                model.addAttribute("noHistory", (boolean) true);
                return "dashboardPayment";
            } else {

                Collections.reverse(listHistory);
                model.addAttribute("noHistory", (boolean) false);
                model.addAttribute("listHistory", listHistory);
                return "dashboardPayment";
            }
        } else {
            return "redirect:/signin";
        }
    }
}
