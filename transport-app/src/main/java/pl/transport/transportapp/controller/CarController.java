package pl.transport.transportapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.transport.transportapp.model.car.Car;
import pl.transport.transportapp.model.car.CarDetails;
import pl.transport.transportapp.model.dto.CarDTO;
import pl.transport.transportapp.serviceNew.ServiceView;
import pl.transport.transportapp.util.AtributesName;
import pl.transport.transportapp.util.Mappings;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {


//    private CarService carService;
    private pl.transport.transportapp.serviceNew.CarService carService;
    private ServiceView<CarDTO> carViewService;

    @Autowired
    public CarController(pl.transport.transportapp.serviceNew.CarService carService, ServiceView<CarDTO> carViewService) {
        this.carService = carService;
        this.carViewService = carViewService;
    }

    @ModelAttribute
    public CarDTO carView(CarDTO carView){
        return carViewService.getVIew();
    }

    @GetMapping("/add")
    public String addFormCar(Model model){
       return Mappings.CAR_FORM_ADD;
    }


    @PostMapping("/add")
    public String addCar(@Valid @ModelAttribute(AtributesName.CAR_VIEW)CarDTO carView, BindingResult result , Model model){
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            model.addAttribute("error",result);
            return Mappings.CAR_FORM_ADD;
        }else {
            CarDetails carDetails = new CarDetails(carView.getBrand(), carView.getModel(), Integer.parseInt(carView.getMileage()));
            Car car = new Car(carView.getPlate(), carDetails);
            carService.add(car);
            return "redirect:/menu";

        }

        }


    @GetMapping("/show")
    public String showCars(Model model){
        List<Car> cars = carService.getAll();

        model.addAttribute("cars",cars);
        return Mappings.CARS;
    }
    @GetMapping("/delete")
    public String deleteCar(@RequestParam long id){
        carService.remove(id);
        return "redirect:/car/show";
    }


}
