package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
