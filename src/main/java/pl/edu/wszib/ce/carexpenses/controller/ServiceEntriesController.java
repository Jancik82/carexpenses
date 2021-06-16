package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.ce.carexpenses.dao.ServiceEntriesDao;
import pl.edu.wszib.ce.carexpenses.model.ServiceEntries;

@Controller
@RequestMapping("/service")
public class ServiceEntriesController {

    @Autowired
    private ServiceEntriesDao serviceEntriesDao;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("serviceadd", new ServiceEntries());
        model.addAttribute("serviceentries", serviceEntriesDao.findAll());
        return "service";
    }

    @PostMapping()
    public String createTable(ServiceEntries serviceEntries) {
        serviceEntriesDao.save(serviceEntries);
        return "redirect:/service";
    }
}
