package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.ce.carexpenses.model.FuelEntries;
import pl.edu.wszib.ce.carexpenses.dao.FuelEntriesDao;

@Controller
@RequestMapping("/fuel")
public class FuelEntriesController {

    @Autowired
    private FuelEntriesDao fuelEntriesDao;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("fueladd", new FuelEntries());
        model.addAttribute("fuelentries", fuelEntriesDao.findAll());
        return "fuel";
    }

    @PostMapping()
    public String createTable(FuelEntries fuelEntries) {
        fuelEntriesDao.save(fuelEntries);
        return "redirect:/fuel";
    }
}
