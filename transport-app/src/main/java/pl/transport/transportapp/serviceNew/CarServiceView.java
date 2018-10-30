package pl.transport.transportapp.serviceNew;

import org.springframework.stereotype.Service;
import pl.transport.transportapp.model.dto.CarDTO;

@Service
public class CarServiceView implements ServiceView<CarDTO> {
    @Override
    public CarDTO getVIew() {
        return new CarDTO();
    }
}
