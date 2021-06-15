package pl.edu.wszib.ce.carexpenses.model;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ServiceEntries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date serviceDate;

    @Size(min = 3, max = 50, message = "Liczba znaków powinna mieć długość od 3 do 50")
    private String description;

    @Min(value = 1, message = "Wartość musi być liczbą dodatnią")
    private Float cost;

    public ServiceEntries() {
    }

    public ServiceEntries(Date serviceDate, String description, Float cost) {
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
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
