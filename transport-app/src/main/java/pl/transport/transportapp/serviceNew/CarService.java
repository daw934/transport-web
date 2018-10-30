package pl.transport.transportapp.serviceNew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.transport.transportapp.model.car.Car;
@Service
public abstract class CarService extends JpaService<Car> {

    public CarService(JpaRepository<Car, Long> jpaRepository) {
        super(jpaRepository);
    }

    public  abstract boolean exist(String plate);
    public abstract Car findCar(String plate);
   
}
