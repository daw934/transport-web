package pl.transport.transportapp.serviceNew;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.transport.transportapp.model.dto.JourneyOrderDto;

import java.util.List;

public class JourneyOrderViewService extends JpaService<JourneyOrderDto>{
    public JourneyOrderViewService(JpaRepository<JourneyOrderDto, Long> jpaRepository) {
        super(jpaRepository);
    }


}
