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
public class OtherExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Data nie może być z przyszłości")
    private Date otherExpensesDate;

    @NotNull
    @Size(min = 3, max = 50, message = "Liczba znaków powinna mieć długość od 3 do 50")
    private String description;

    @NotNull
    @Min(value = 1, message = "Podaj liczbę dodatnią. Wartość dziesiętną oddziel kropką")
    private Float cost;

    public OtherExpenses() {
    }

    public OtherExpenses(Date otherExpensesDate, String description, Float cost) {
        this.otherExpensesDate = otherExpensesDate;
        this.description = description;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOtherExpensesDate() {
        return otherExpensesDate;
    }

    public void setOtherExpensesDate(Date otherExpensesDate) {
        this.otherExpensesDate = otherExpensesDate;
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
