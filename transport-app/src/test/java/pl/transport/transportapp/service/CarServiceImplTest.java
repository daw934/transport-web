package pl.transport.transportapp.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.transport.transportapp.repository.CarDetailsRepository;
import pl.transport.transportapp.repository.CarRepository;
import pl.transport.transportapp.serviceNew.CarServiceImplNew;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CarServiceImplTest {


    CarServiceImplNew carService;
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarDetailsRepository carDetailsRepository;

//    TestEntityManager entityManager;



    @Before
    void setUp(){

    }

    @Test
    void shouldGet() {
//        assertThrows(NullPointerException.class,()->carRepository.existsById(2L));
//        carRepository.getOne(2L);
    }
}