package pl.edu.wszib.ce.carexpenses.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class ConstantCosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data nie może być z przyszłości")
    private Date constantCostsDate;

    @Size(min = 3, max = 50, message = "Liczba znaków powinna mieć długość od 3 do 50")
    private String description;


    @NotNull
    @Min(value = 1, message = "Podaj liczbę dodatnią. Wartość dziesiętną oddziel kropką")
    private Float constantCost;

    public ConstantCosts() {
    }

    public ConstantCosts(Date constantCostsDate, String description, Float constantCost) {
        this.constantCostsDate = constantCostsDate;
        this.description = description;
        this.constantCost = constantCost;
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

    public Float getConstantCost() {
        return constantCost;
    }

    public void setConstantCost(Float constantCost) {
        this.constantCost = constantCost;
    }
}
