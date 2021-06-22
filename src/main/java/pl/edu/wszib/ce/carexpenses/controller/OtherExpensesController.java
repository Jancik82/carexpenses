package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ce.carexpenses.dao.OtherExpensesDao;
import pl.edu.wszib.ce.carexpenses.model.OtherExpenses;
import pl.edu.wszib.ce.carexpenses.service.OtherExpensenService;

@Controller
public class OtherExpensesController {

    @Autowired
    private OtherExpensesDao otherExpensesDao;

    @Autowired
    private OtherExpensenService otherExpensenService;

    @GetMapping("/other")
    public String getAll(Model model) {
        model.addAttribute("otheradd", new OtherExpenses());
        model.addAttribute("otherexpenses", otherExpensesDao.findAll());
        return "other";
    }

    @GetMapping("/otherstat")
    public String getStat(Model model){
        model.addAttribute("sumCostOther", otherExpensenService.sumCostOther());
        model.addAttribute("minCostOther", otherExpensenService.minCostOther());
        model.addAttribute("minDescriptionOther", otherExpensenService.minDescriptionOther());
        model.addAttribute("maxCostOther", otherExpensenService.maxCostOther());
        model.addAttribute("maxDescriptionOther", otherExpensenService.maxDescriptionOther());
        model.addAttribute("avgCostOther", otherExpensenService.avgCostOther());
        return "otherstat";
    }

    @PostMapping("/other")
    public String createTable(OtherExpenses otherExpenses) {
        otherExpensesDao.save(otherExpenses);
        return "redirect:/other";
    }
}
