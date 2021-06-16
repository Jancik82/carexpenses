package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/welcome")
    public String index(Model model) {
        return "welcome";
    }
}
