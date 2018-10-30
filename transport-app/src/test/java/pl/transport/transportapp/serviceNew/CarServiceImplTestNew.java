package pl.transport.transportapp.serviceNew;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.transport.transportapp.model.car.Car;
import pl.transport.transportapp.model.car.CarDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CarServiceImplTestNew {

    @Autowired
    private CarService carService;
//    @Autowired
//    private CarRepository carRepository;

    private Car car;
    @BeforeEach
    public void setUp(){
        car = new Car();
        car.setPlate("ZZZ1111");
        car.setCarDetails(new CarDetails("1","1",1));
//        carService.add(car);
    }
    @Test
    void correctInsert(){
//        car = new Car();
//        car.setPlate("ZZZ1111");
//        car.setCarDetails(new CarDetails("1","1",1));
        carService.add(car);
        Car car1 =carService.findCar("ZZZ1111");
        assertEquals(car.getPlate(),car1.getPlate());
        car.setPlate("SSS2323");
        carService.update(car);
        Car car2 =carService.findCar("SSS2323");
        assertEquals(car.getId(),car2.getId());


    }
    @Test
    void correctDelete(){
//        Car car = new Car();
//        car.setPlate("ZZZ1111");
//        car.setCarDetails(new CarDetails("1","1",1));
        carService.add(car);
        Car car1 =carService.findCar("ZZZ1111");
        assertEquals(car.getPlate(),car1.getPlate());
        carService.remove(car.getId());
        car1 =carService.findCar("ZZZ1111");
        assertEquals(car1,null);
    }

}