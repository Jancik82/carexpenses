package pl.edu.wszib.ce.carexpenses.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.wszib.ce.carexpenses.service.FuelEntriesServiceImpl;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
public class FuelEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date refuelingDate;

    @NotNull
    @Min(value = 1, message = "Wartość musi być liczbą dodatnią")
    private Float fueledFuel;

    @NotNull
    @Min(value = 1, message = "Wartość musi być liczbą dodatnią")
    private Float distance;

    @Column
    @NotNull
    private Float avgFuel;

    @NotNull
    @Min(value = 1, message = "Wartość musi być liczbą dodatnią")
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

    public Float getAvgFuel() {
        return avgFuel;
    }

    public void setAvgFuel(Float avgFuel) {
        this.avgFuel = avgFuel;
    }
}
