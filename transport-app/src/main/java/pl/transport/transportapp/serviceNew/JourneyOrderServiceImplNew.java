package pl.transport.transportapp.serviceNew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.transport.transportapp.model.journey.JourneyOrder;
import pl.transport.transportapp.repository.JourneyOrderRepository;

@org.springframework.stereotype.Service
public class JourneyOrderServiceImplNew extends JourneyOrderServiceNew {


    private JourneyOrderRepository journeyOrderRepository;

    @Autowired
    public JourneyOrderServiceImplNew(JpaRepository<JourneyOrder, Long> jpaRepository) {
        super(jpaRepository);
    }

    @Override
    public boolean exist(long id) {
        return journeyOrderRepository.existsById(id);
    }


}
