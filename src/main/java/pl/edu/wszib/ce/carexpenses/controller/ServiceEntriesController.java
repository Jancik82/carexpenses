package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.ce.carexpenses.dao.ServiceEntriesDao;
import pl.edu.wszib.ce.carexpenses.model.ServiceEntries;
import pl.edu.wszib.ce.carexpenses.service.ServiceEntriesService;

@Controller
public class ServiceEntriesController {

    @Autowired
    private ServiceEntriesDao serviceEntriesDao;

    @Autowired
    private ServiceEntriesService serviceEntriesService;

    @GetMapping("/service")
    public String getAll(Model model) {
        model.addAttribute("serviceadd", new ServiceEntries());
        model.addAttribute("serviceentries", serviceEntriesDao.findAll());
        return "service";
    }

    @GetMapping("/servicestat")
    public String getStat(Model model){
        model.addAttribute("sumCost", serviceEntriesService.sumCostService());
        model.addAttribute("minCost", serviceEntriesService.minCostService());
        model.addAttribute("minDescCost", serviceEntriesService.minDescriptionService());
        model.addAttribute("maxCost", serviceEntriesService.maxCostService());
        model.addAttribute("maxDescCost", serviceEntriesService.maxDescriptionService());
        model.addAttribute("avgCost", serviceEntriesService.avgCostService());
        return "servicestat";
    }


    @PostMapping("/service")
    public String createTable(ServiceEntries serviceEntries) {
        serviceEntriesDao.save(serviceEntries);
        return "redirect:/service";
    }
}
