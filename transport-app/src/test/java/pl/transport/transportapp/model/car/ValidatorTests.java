package pl.transport.transportapp.model.car;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.transport.transportapp.model.driver.Driver;
import pl.transport.transportapp.model.dto.CarDTO;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
//@RunWith(SpringRunner.class)
class ValidatorTests {


    private javax.validation.Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }




    @Test
    void wrongPesel(){

        Driver driver = new Driver();
        driver.setFirstName("firstname");
        driver.setLastName("lastname");
        driver.setPesel("12345678901");

        Validator validator = createValidator();
        Set<ConstraintViolation<Driver>> constraintViolations = validator.validate(driver);
        assertEquals(0,constraintViolations.size());
        driver.setPesel("123");
        constraintViolations = validator.validate(driver);
        assertEquals(1,constraintViolations.size());
        ConstraintViolation<Driver> violation = constraintViolations.iterator().next();
        assertEquals("pesel should include 11 digits",violation.getMessage());

        driver.setPesel("12d31111111");
        constraintViolations = validator.validate(driver);
        assertEquals(1,constraintViolations.size());
        violation = constraintViolations.iterator().next();
        assertEquals("pesel should consist only digits",violation.getMessage());

//        pesel should consist only digits
//        assertTrue(constraintViolations.size() == 1);
//        ConstraintViolation<Driver> violation = constraintViolations.iterator().next();
//        System.out.println(violation.getMessage());
//        assertTrue(violation.getMessage().equals(ConstraintViolation.class.getAnnotations().);


    }
    @Test
    void wrongCarViewPlate(){
        CarDTO carView = new CarDTO();
        carView.setPlate("SDD4444");
        carView.setBrand("brand");
        carView.setMileage("123");
        carView.setModel("model");


        Validator validator = createValidator();
        Set<ConstraintViolation<CarDTO>> constraintViolations = validator.validate(carView);
        assertEquals(0,constraintViolations.size());
        carView.setPlate("DD222");
        constraintViolations = validator.validate(carView);
        assertEquals(1,constraintViolations.size());
        ConstraintViolation<CarDTO> violation = constraintViolations.iterator().next();
//        assertTrue(violation.getMessage().equals("Passwords don't match"));
        assertEquals("Plate don't match to plate in poland",violation.getMessage());
        carView.setPlate("aaa11111");
        assertEquals(1,constraintViolations.size());
        carView.setPlate("aa111111");
        assertEquals(1,constraintViolations.size());

    }

}