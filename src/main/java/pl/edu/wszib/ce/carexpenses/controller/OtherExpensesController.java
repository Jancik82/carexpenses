package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ce.carexpenses.dao.OtherExpensesDao;
import pl.edu.wszib.ce.carexpenses.model.OtherExpenses;
import pl.edu.wszib.ce.carexpenses.service.OtherExpensenService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class OtherExpensesController {

    @Autowired
    private OtherExpensesDao otherExpensesDao;

    @Autowired
    private OtherExpensenService otherExpensenService;

    @GetMapping("/other")
    public String getAll(Model model) {
        model.addAttribute("otheradd", new OtherExpenses(new Date(), "", 0.0F));
        model.addAttribute("otherexpenses", otherExpensesDao.findAll());
        return "other";
    }

    @PostMapping("/other")
    public String createTable(@Valid @ModelAttribute("otheradd") OtherExpenses otherExpenses, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("otherexpenses", otherExpensesDao.findAll());
            return "other";
        }
        otherExpensesDao.save(otherExpenses);
        return "redirect:/other";
    }

    @GetMapping("/otherstat")
    public String getStat(Model model) {
        model.addAttribute("sumCostOther", otherExpensenService.sumCostOther());
        model.addAttribute("minCostOther", otherExpensenService.minCostOther());
        model.addAttribute("minDescriptionOther", otherExpensenService.minDescriptionOther());
        model.addAttribute("maxCostOther", otherExpensenService.maxCostOther());
        model.addAttribute("maxDescriptionOther", otherExpensenService.maxDescriptionOther());
        model.addAttribute("avgCostOther", otherExpensenService.avgCostOther());
        return "otherstat";
    }
}
