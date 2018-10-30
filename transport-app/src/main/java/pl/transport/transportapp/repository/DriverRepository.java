package pl.transport.transportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.transport.transportapp.model.driver.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
    Driver findByPesel(String pesel);
//    boolean existsByPesel(String pesel);
//    boolean existsByLastName(String lastName);
    Driver findByLastName(String lastName);
}
