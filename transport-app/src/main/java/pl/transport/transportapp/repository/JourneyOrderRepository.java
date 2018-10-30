package pl.transport.transportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.transport.transportapp.model.journey.JourneyOrder;

public interface JourneyOrderRepository extends JpaRepository<JourneyOrder,Long> {

}
