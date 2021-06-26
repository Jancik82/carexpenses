package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ce.carexpenses.dao.ServiceEntriesDao;
import pl.edu.wszib.ce.carexpenses.model.ServiceEntries;
import pl.edu.wszib.ce.carexpenses.service.ServiceEntriesService;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class ServiceEntriesController {

    @Autowired
    private ServiceEntriesDao serviceEntriesDao;

    @Autowired
    private ServiceEntriesService serviceEntriesService;

    @GetMapping("/service")
    public String getAll(Model model) {
        model.addAttribute("serviceadd", new ServiceEntries(new Date(), "", 0.0F));
        model.addAttribute("serviceentries", serviceEntriesDao.findAll());
        return "service";
    }

    @PostMapping("/service")
    public String createTable(@Valid @ModelAttribute("serviceadd") ServiceEntries serviceEntries, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceentries", serviceEntriesDao.findAll());
            return "service";
        }
        serviceEntriesDao.save(serviceEntries);
        return "redirect:/service";
    }

    @GetMapping("/servicestat")
    public String getStat(Model model) {
        model.addAttribute("sumCost", serviceEntriesService.sumCostService());
        model.addAttribute("minCost", serviceEntriesService.minCostService());
        model.addAttribute("minDescCost", serviceEntriesService.minDescriptionService());
        model.addAttribute("maxCost", serviceEntriesService.maxCostService());
        model.addAttribute("maxDescCost", serviceEntriesService.maxDescriptionService());
        model.addAttribute("avgCost", serviceEntriesService.avgCostService());
        return "servicestat";
    }
}
