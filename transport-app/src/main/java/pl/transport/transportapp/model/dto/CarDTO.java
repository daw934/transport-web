package pl.transport.transportapp.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.transport.transportapp.validator.PlateMatches;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter

public class CarDTO {

    @PlateMatches
    private String plate;
    @NotEmpty
    private String brand;
    @NotEmpty
    private String model;
//    @NotEmpty
    @Digits(fraction = 0, integer = 10000000, message = "Number has to be between 0 and 10000000")
    private String mileage;

    public CarDTO(String plate, String brand, String model, String mileage) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
    }

    public CarDTO() {
    }
}
