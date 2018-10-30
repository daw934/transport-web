package pl.transport.transportapp.serviceNew;

import org.springframework.beans.factory.annotation.Autowired;
import pl.transport.transportapp.model.driver.Driver;
import pl.transport.transportapp.repository.DriverRepository;

@org.springframework.stereotype.Service
public class DriverServiceImplNew extends pl.transport.transportapp.serviceNew.DriverService {



    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImplNew(DriverRepository driverRepository) {
        super(driverRepository);
        this.driverRepository = driverRepository;
    }


//    @Override
//    public boolean existByPesel(String pesel) {
//        return driverRepository.existsByPesel(pesel);
//    }
//
//    @Override
//    public boolean existByLastName(String lastName) {
//        return driverRepository.existsByLastName(lastName);
//    }

    @Override
    public void insertOrUpdate(Driver driver) {
        Driver driver1 = driverRepository.findByPesel(driver.getPesel());
        if (driver1 == null) {
            driverRepository.save(driver);
        }else {
            driver.setId(driver1.getId());
            driverRepository.save(driver);
        }
    }

    @Override
    public Driver find(String lastName) {
        return driverRepository.findByLastName(lastName);
    }
}
