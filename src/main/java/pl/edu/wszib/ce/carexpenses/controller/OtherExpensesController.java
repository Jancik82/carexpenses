package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.ce.carexpenses.dao.OtherExpensesDao;
import pl.edu.wszib.ce.carexpenses.model.OtherExpenses;

@Controller
@RequestMapping("/other")
public class OtherExpensesController {

    @Autowired
    private OtherExpensesDao otherExpensesDao;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("otheradd", new OtherExpenses());
        model.addAttribute("otherexpenses", otherExpensesDao.findAll());
        return "other";
    }

    @PostMapping()
    public String createTable(OtherExpenses otherExpenses) {
        otherExpensesDao.save(otherExpenses);
        return "redirect:/other";
    }
}
