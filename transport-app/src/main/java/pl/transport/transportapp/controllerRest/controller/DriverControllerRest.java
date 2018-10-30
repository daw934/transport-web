package pl.transport.transportapp.controllerRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.transport.transportapp.model.driver.Driver;
import pl.transport.transportapp.serviceNew.DriverService;
import pl.transport.transportapp.util.Mappings;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverControllerRest {

    private DriverService service;

    @ModelAttribute
    public Driver driver(Driver driver){
        return new Driver();
    }
    @Autowired
    public DriverControllerRest(DriverService service) {
        this.service = service;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addDriver(@RequestBody Driver driver){
        System.out.println("driver");
        service.add(driver);
    }
    @GetMapping(path ="/{id}")
    public Driver getDriver(@PathVariable long id){
        return service.get(id);
    }
    @GetMapping()
    public List<Driver> getDrivers(){
        return service.getAll();
    }
//
//    @PostMapping("/add")
//    public String addDriver(@Valid @ModelAttribute Driver driver, BindingResult result, Model model){
//        if(result.hasErrors()) {
//            List<ObjectError> errors = result.getAllErrors();
//
//            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
//            model.addAttribute("error", result);
//            return Mappings.DRIVER_FORM_ADD;
//        }else
//        service.insertOrUpdate(driver);
//        return "redirect:/driver";
//
//    }
//
//    @GetMapping()
//    public String menuDriver(Model model){
//        List<Driver> drivers = service.getAll();
//        model.addAttribute("drivers",drivers);
//        return Mappings.DRIVER_MENU;
//    }
//    @GetMapping("/add")
//    public String addDriverForm(){
//        return Mappings.DRIVER_FORM_ADD;
//    }
//    @GetMapping("/delete")
//    public String deleteDriver(@RequestParam long id){
//        service.remove(id);
//        return "redirect:/driver";
//
//    }

}
