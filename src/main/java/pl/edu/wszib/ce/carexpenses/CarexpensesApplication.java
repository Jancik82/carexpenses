package pl.edu.wszib.ce.carexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:db.properties")
public class CarexpensesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarexpensesApplication.class, args);
    }

}
