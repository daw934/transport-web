package pl.transport.transportapp.serviceNew;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.transport.transportapp.model.car.Car;
import pl.transport.transportapp.model.dto.CarDTO;
import pl.transport.transportapp.repository.CarDetailsRepository;
import pl.transport.transportapp.repository.CarRepository;

@Service
@Primary
public class CarServiceImplNew extends CarService {

    CarRepository carRepository;
    CarDetailsRepository carDetailsRepository;

    @Getter
    CarDTO carView = new CarDTO();
    @Autowired
    public CarServiceImplNew(CarRepository carRepository, CarDetailsRepository carDetailsRepository) {
        super(carRepository);
        this.carRepository = carRepository;
        this.carDetailsRepository =carDetailsRepository;
    }

    @Override
    public boolean exist(String plate) {
        return carRepository.existsByPlate(plate);
    }

    @Override
    public Car findCar(String plate) {
        return carRepository.findCarByPlate(plate);
    }
}
