package pl.transport.transportapp.model.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.transport.transportapp.model.journey.JourneyOrder;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "driver")
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_driver")
    private long id;

    @Column(nullable = false)
    @Digits(fraction = 0, integer = 11,message = "pesel should consist only digits")
    @Size(min = 11,max = 11, message = "pesel should include 11 digits")
    private String pesel;

    @Column(nullable = false, name = "first_name")
    @NotEmpty
    private String firstName;

    @Column(nullable = false,name = "last_name")
    @NotEmpty
    private String lastName;

    @OneToMany(mappedBy = "driver")
    private List<JourneyOrder> journeyOrder;
}
