package pl.edu.wszib.ce.carexpenses.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class FuelEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data nie może być z przyszłości")
    private Date refuelingDate;

    @NotNull
    @Min(value = 1, message = "Wartość musi być równa lub większa od 1")
    @Max(value = 200, message = "Wartość musi być równa lub mniejsza od 200")
    private Float fueledFuel;

    @NotNull
    @Min(value = 1, message = "Wartość musi być równa lub większa od 1")
    @Max(value = 3000, message = "Wartość musi być równa lub mniejsza od 3000")
    private Float distance;

    @NotNull
    @Min(value = 1, message = "Wartość musi być równa lub większa od 1")
    @Max(value = 5000, message = "Wartość musi być równa lub mniejsza od 5000")
    private Float cost;
    public FuelEntries() {
    }

    public FuelEntries(Date refuelingDate, Float fueledFuel, Float distance, Float cost) {
        this.refuelingDate = refuelingDate;
        this.fueledFuel = fueledFuel;
        this.distance = distance;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRefuelingDate() {
        return refuelingDate;
    }

    public void setRefuelingDate(Date refuelingDate) {
        this.refuelingDate = refuelingDate;
    }

    public Float getFueledFuel() {
        return fueledFuel;
    }

    public void setFueledFuel(Float fueledFuel) {
        this.fueledFuel = fueledFuel;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float value) {
        this.cost = value;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
