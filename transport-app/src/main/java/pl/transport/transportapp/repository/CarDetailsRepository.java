package pl.transport.transportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transport.transportapp.model.car.CarDetails;

@Repository
public interface CarDetailsRepository extends JpaRepository<CarDetails, Long> {
}
