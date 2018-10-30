package pl.transport.transportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transport.transportapp.model.car.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>{

    Car findCarByPlate(String plate);

    boolean existsByPlate(String plate);

}
