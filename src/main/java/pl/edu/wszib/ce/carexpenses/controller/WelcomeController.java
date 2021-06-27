package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/welcome")
    public String index(Model model) {
        return "welcome";
    }

    @GetMapping("/welcome")
    public String getStatConstant(Model model){
        model.addAttribute("sumCost", fuelEntriesService.sumCostFuel());
        model.addAttribute("sumCost", serviceEntriesService.sumCostService());
        model.addAttribute("sumCostConst", constantCostService.sumCostConst());
        model.addAttribute("sumCostOther", otherExpensenService.sumCostOther());
        model.addAttribute("sumTotal", sumTotal());
        model.addAttribute("costKm", costKm());
        return "welcome";
    }

    public Float sumTotal(){

        Float fuel = 0F;
        Float service = 0F;
        Float constant = 0F;
        Float other = 0F;

        if(fuelEntriesService.sumCostFuel() != null){
            fuel += fuelEntriesService.sumCostFuel();
        }
        if(serviceEntriesService.sumCostService() != null){
            service += serviceEntriesService.sumCostService();
        }
        if(constantCostService.sumCostConst() != null){
            constant += constantCostService.sumCostConst();
        }
        if(otherExpensenService.sumCostOther() != null){
           other += otherExpensenService.sumCostOther();
        }

        return fuel + service + constant + other;
    }

    public Float costKm (){

        Float totalDist = 0F;
        if(fuelEntriesService.sumDistFuel() != null){
            totalDist += fuelEntriesService.sumDistFuel();
        }
        return ((100*sumTotal())/totalDist);

    }

}
