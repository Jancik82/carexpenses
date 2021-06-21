package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.ce.carexpenses.model.FuelEntries;
import pl.edu.wszib.ce.carexpenses.dao.FuelEntriesDao;
import pl.edu.wszib.ce.carexpenses.service.FuelEntriesService;

@Controller
//@RequestMapping("/fuel")
public class FuelEntriesController {

    @Autowired
    private FuelEntriesDao fuelEntriesDao;

    @Autowired
    private FuelEntriesService fuelEntriesService;

    @GetMapping("/fuel")
    public String getAll(Model model) {
        model.addAttribute("fueladd", new FuelEntries());
        model.addAttribute("fuelentries", fuelEntriesDao.findAll());
        return "fuel";
    }

    @GetMapping("/fuelstat")
    public String getStat(Model model) {
        model.addAttribute("sumCost", fuelEntriesService.sumCostFuel());
        model.addAttribute("sumDist", fuelEntriesService.sumDistFuel());
        model.addAttribute("minCost", fuelEntriesService.minCostFuel());
        model.addAttribute("maxCost", fuelEntriesService.maxCostFuel());
        model.addAttribute("avgCost", fuelEntriesService.avgCostFuel());
        model.addAttribute("minDist", fuelEntriesService.minDistFuel());
        model.addAttribute("maxDist", fuelEntriesService.maxDistFuel());
        model.addAttribute("avgDist", fuelEntriesService.avgDistFuel());
        model.addAttribute("avgFuelConsupt", fuelEntriesService.avgFuelConsupt());
                model.addAttribute("avgFuelDist", fuelEntriesService.avgFuelDist());
        return "fuelstat";
    }

    @PostMapping("/fuel")
    public String createTable(FuelEntries fuelEntries) {
        fuelEntriesDao.save(fuelEntries);
        return "redirect:/fuel";
    }
}
