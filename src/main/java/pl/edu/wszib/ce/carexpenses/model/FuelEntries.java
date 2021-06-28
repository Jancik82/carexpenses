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
public class FuelEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data nie może być z przyszłości")
    private Date refuelingDate;

    @NotNull
    @Min(value = 1, message = "Podaj liczbę dodatnią. Wartość dziesiętną oddziel kropką")
    private Float fueledFuel;

    @NotNull
    @Min(value = 1, message = "Podaj liczbę dodatnią. Wartość dziesiętną oddziel kropką")
    private Float distance;

    @NotNull
    @Min(value = 1, message = "Podaj liczbę dodatnią. Wartość dziesiętną oddziel kropką")
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
