package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ce.carexpenses.model.FuelEntries;
import pl.edu.wszib.ce.carexpenses.dao.FuelEntriesDao;
import pl.edu.wszib.ce.carexpenses.service.FuelEntriesService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class FuelEntriesController {

    @Autowired
    private FuelEntriesDao fuelEntriesDao;

    @Autowired
    private FuelEntriesService fuelEntriesService;

    @GetMapping("/fuel")
    public String getAll(Model model) {
        model.addAttribute("fueladd", new FuelEntries(new Date(), 0.0F, 0.0F, 0.0F));
        model.addAttribute("fuelentries", fuelEntriesDao.findAll());
        return "fuel";
    }

    @PostMapping("/fuel")
    public String createTable(@Valid @ModelAttribute("fueladd") FuelEntries fuelEntries, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("fuelentries", fuelEntriesDao.findAll());
            return "fuel";
        }
        fuelEntriesDao.save(fuelEntries);
        return "redirect:/fuel";
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
}
