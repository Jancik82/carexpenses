package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ce.carexpenses.dao.ConstantCostsDao;
import pl.edu.wszib.ce.carexpenses.model.ConstantCosts;
import pl.edu.wszib.ce.carexpenses.service.ConstantCostService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class ConstantCostsController {

    @Autowired
    private ConstantCostsDao constantCostsDao;

    @Autowired
    private ConstantCostService constantCostService;

    @GetMapping("/constant")
    public String getAll(Model model) {
        model.addAttribute("constantadd", new ConstantCosts(new Date(), "", 0.0F));
        model.addAttribute("constantcosts", constantCostsDao.findAll());
        return "constant";
    }

    @PostMapping("/constant")
    public String createTable(@Valid @ModelAttribute("constantadd") ConstantCosts constantCosts, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("constantcosts", constantCostsDao.findAll());
            return "constant";
        }
        constantCostsDao.save(constantCosts);
        return "redirect:/constant";
    }

    @GetMapping("/constantstat")
    public String getStat(Model model) {
        model.addAttribute("sumCostConst", constantCostService.sumCostConst());
        model.addAttribute("sumInstallment", constantCostService.sumInstallment());
        model.addAttribute("sumRent", constantCostService.sumRent());
        model.addAttribute("sumTechExem", constantCostService.sumTechExem());
        model.addAttribute("sumInsuranceOC", constantCostService.sumInsuranceOC());
        model.addAttribute("sumInsuranceOther", constantCostService.sumInsuranceOther());
        model.addAttribute("sumPark", constantCostService.sumPark());
        model.addAttribute("sumOther", constantCostService.sumOther());
        return "constantstat";
    }
}
