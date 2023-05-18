package com.koceku.koceku.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.koceku.koceku.Model.*;

@Controller
public class TransferController {

    private ArrayList<History> listHistory = new ArrayList<>();

    @GetMapping("/transfer")
    public String Transfer(Model model) {
        History h1 = new History("Transfer",
                "08221212313121", "wahyu", "20000", "Income");
        listHistory.add(h1);
        return "transfer";
    }

}
