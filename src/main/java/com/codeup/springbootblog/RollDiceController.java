package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/n")
    public String displayRoll() {
        int roll = (int) Math.ceil(Math.random() * 6);
        return "roll-dice/n";
    }
}
