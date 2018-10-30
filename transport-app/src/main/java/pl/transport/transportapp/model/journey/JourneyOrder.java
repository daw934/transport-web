package pl.transport.transportapp.model.journey;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.transport.transportapp.model.car.Car;
import pl.transport.transportapp.model.driver.Driver;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "journey_order")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JourneyOrder {

    @Id ///dsdsd
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_journey_order")
    private long id;

    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "YYYY-MM-DD ")
    private Date date;

    @Column(nullable = false)
    private String destination;


    @ManyToOne
    private Car car;

    @ManyToOne
    private Driver driver;
}
