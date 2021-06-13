package pl.edu.wszib.ce.carexpenses.model;

import com.sun.istack.NotNull;
import org.intellij.lang.annotations.Pattern;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Float value;

    public FuelEntries() {
    }

    public FuelEntries(Date refuelingDate, Float fueledFuel, Float value) {
        this.refuelingDate = refuelingDate;
        this.fueledFuel = fueledFuel;
        this.value = value;
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

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
