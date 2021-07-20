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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data nie może być z przyszłości")
    private Date serviceDate;

    @NotNull
    @Size(min = 3, max = 50, message = "Opis powinien zawierać od 3 do 50 znaków")
    private String description;

    @NotNull
    @Min(value = 1, message = "Wartość musi być równa lub większa od 1")
    @Max(value = 50000, message = "Wartość musi być równa lub mniejsza od 50000")
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
