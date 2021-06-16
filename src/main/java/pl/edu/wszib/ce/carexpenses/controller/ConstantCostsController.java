package pl.edu.wszib.ce.carexpenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.ce.carexpenses.dao.ConstantCostsDao;
import pl.edu.wszib.ce.carexpenses.model.ConstantCosts;

@Repository
@RequestMapping("/constant")
public class ConstantCostsController {

    @Autowired
    private ConstantCostsDao constantCostsDao;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("constantadd", new ConstantCosts());
        model.addAttribute("constantcosts", constantCostsDao.findAll());
        return "constant";
    }

    @PostMapping()
    public String createTable(ConstantCosts constantCosts) {
        constantCostsDao.save(constantCosts);
        return "redirect:/constant";
    }
}
