package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.ce.carexpenses.service.ConstantCostService;
import pl.edu.wszib.ce.carexpenses.service.FuelEntriesService;
import pl.edu.wszib.ce.carexpenses.service.OtherExpensenService;
import pl.edu.wszib.ce.carexpenses.service.ServiceEntriesService;

@Controller
public class WelcomeController {

    @Autowired
    FuelEntriesService fuelEntriesService;

    @Autowired
    ServiceEntriesService serviceEntriesService;

    @Autowired
    ConstantCostService constantCostService;

    @Autowired
    OtherExpensenService otherExpensenService;

    @GetMapping("/welcome")
    public String getStatConstant(Model model) {
        model.addAttribute("sumCostFuel", sumFuel());
        model.addAttribute("sumCostService", sumService());
        model.addAttribute("sumCostConst", sumConstant());
        model.addAttribute("sumCostOther", sumOthert());
        model.addAttribute("sumTotal", sumTotal());
        model.addAttribute("costKm", costKm());
        return "welcome";
    }

    public Float sumFuel() {
        Float fuel = 0F;

        if (fuelEntriesService.sumCostFuel() != null) {
            fuel += fuelEntriesService.sumCostFuel();
        }
        return fuel;
    }

    public Float sumService() {
        Float service = 0F;

        if (serviceEntriesService.sumCostService() != null) {
            service += serviceEntriesService.sumCostService();
        }
        return service;
    }

    public Float sumConstant() {
        Float constant = 0F;

        if (constantCostService.sumCostConst() != null) {
            constant += constantCostService.sumCostConst();
        }
        return constant;
    }

    public Float sumOthert() {
        Float other = 0F;

        if (otherExpensenService.sumCostOther() != null) {
            other += otherExpensenService.sumCostOther();
        }
        return other;
    }

    public Float sumTotal() {
        return sumFuel() + sumService() + sumConstant() + sumOthert();
    }

    public Float costKm() {

        Float tD;
        Float totalDist = 0F;
        if (fuelEntriesService.sumDistFuel() != null) {
            totalDist += fuelEntriesService.sumDistFuel();
        }
        if (totalDist == 0) {
            tD = 0f;
        } else {
            tD = ((100 * sumTotal()) / totalDist);
        }
        return tD;
    }
}
