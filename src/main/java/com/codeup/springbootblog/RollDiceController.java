package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String displayRoll(@PathVariable String n, Model model) {
        int roll = (int) Math.ceil(Math.random() * 6);
        model.addAttribute("roll", roll);
        return "roll-dice";
    }
}
