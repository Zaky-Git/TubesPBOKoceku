package com.koceku.koceku.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

import com.koceku.koceku.Model.*;
import org.springframework.ui.Model.*;

@Controller
public class TransferController {

    private ArrayList<history> listHistory = new ArrayList<>();

    @GetMapping("/transfer")
    public String Transfer(Model model) {
        history h1 = new history("Transfer",
                "08221212313121", "wahyu", "20000", "Income");
        listHistory.add(h1);
        return "transfer";
    }

}
