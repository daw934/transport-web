package pl.transport.transportapp.controllerRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.transport.transportapp.model.car.Car;
import pl.transport.transportapp.model.dto.CarDTO;
import pl.transport.transportapp.serviceNew.ServiceView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarControllerRest {


    //    private CarService service;
    private pl.transport.transportapp.serviceNew.CarService service;
    private ServiceView<CarDTO> carViewService;

    @Autowired
    public CarControllerRest(pl.transport.transportapp.serviceNew.CarService service, ServiceView<CarDTO> carViewService) {
        this.service = service;
        this.carViewService = carViewService;
    }

    @ModelAttribute
    public CarDTO carView(CarDTO carView) {
        return carViewService.getVIew();
    }

    @GetMapping
    public List<Car> getCars(){
        return service.getAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postCar(@RequestBody Car car){
        System.out.println("car");
        service.add(car);
    }
    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id){
        return service.get(id);
    }
}
