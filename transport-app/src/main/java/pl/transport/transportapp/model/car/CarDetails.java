package pl.transport.transportapp.model.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "car_details")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_details")
    private long id;

    @Column(nullable = false)
    @NotEmpty
    private String brand;
    @Column(nullable = false)
    @NotEmpty
    private String model;
    @Column(nullable = false)
    @NumberFormat
    @Min(0)
    private int mileage;

    public CarDetails(String brand, String model, int mileage) {
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
    }

    public CarDetails() {
    }
}
