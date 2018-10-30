package pl.transport.transportapp.serviceNew;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.transport.transportapp.model.driver.Driver;


public abstract class DriverService extends JpaService<Driver> {
//    boolean existByPesel(String pesel);
//    boolean existByLastName(String lastName);


    public DriverService(JpaRepository<Driver, Long> jpaRepository) {
        super(jpaRepository);
    }

    public abstract Driver find(String lastName);
}
