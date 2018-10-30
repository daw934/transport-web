package pl.transport.transportapp.serviceNew;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.transport.transportapp.model.journey.JourneyOrder;

public abstract class JourneyOrderServiceNew extends JpaService<JourneyOrder>{

    public JourneyOrderServiceNew(JpaRepository<JourneyOrder, Long> jpaRepository) {
        super(jpaRepository);
    }

    public  abstract boolean exist(long id);

}
