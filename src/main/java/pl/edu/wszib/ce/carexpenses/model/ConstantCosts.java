package pl.edu.wszib.ce.carexpenses.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
public class ConstantCosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date constantCostsDate;

    private String description;

    @Min(value = 1, message = "Wartość musi być liczbą dodatnią")
    private Float cost;

    public ConstantCosts() {
    }

    public ConstantCosts(Date constantCostsDate, String description, Float cost) {
        this.constantCostsDate = constantCostsDate;
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getConstantCostsDate() {
        return constantCostsDate;
    }

    public void setConstantCostsDate(Date constantCostsDate) {
        this.constantCostsDate = constantCostsDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
