package com.koceku.koceku.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.koceku.koceku.Model.*;
import com.koceku.koceku.Repositories.*;

@Controller
public class TopUp {

    @GetMapping("/topup")
    public String topup(Model model) {
        return "topup";
    }
}
