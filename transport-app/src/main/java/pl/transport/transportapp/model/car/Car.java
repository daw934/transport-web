package pl.transport.transportapp.model.car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pl.transport.transportapp.model.journey.JourneyOrder;
import pl.transport.transportapp.validator.PlateMatches;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "car")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private long id;
    @PlateMatches
    private String plate;

    @OneToOne(cascade = CascadeType.ALL)
    private CarDetails carDetails;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "car" )
    private List<JourneyOrder> journeyOrder;

    public Car(String plate, CarDetails carDetails) {
        this.plate = plate;
        this.carDetails = carDetails;
    }

    public Car() {

    }



}
