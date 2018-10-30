package pl.transport.transportapp.model.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import pl.transport.transportapp.validator.DateMatches;
import pl.transport.transportapp.validator.PlateMatches;

import javax.validation.constraints.NotEmpty;

@Component
@Getter
@Setter
public class JourneyOrderDto {
    @NotEmpty
    private String destination;
    @NotEmpty
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @DateMatches
    private String date;
    @NotEmpty
    private String driverLastName;
    @NotEmpty
    @PlateMatches
    private String carPlate;

    public JourneyOrderDto() {
    }
}
