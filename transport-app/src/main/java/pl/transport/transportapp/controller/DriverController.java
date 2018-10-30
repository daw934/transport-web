package pl.transport.transportapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/driver")
public class DriverController {

    private DriverService driverService;

    @ModelAttribute
    public Driver driver(Driver driver){
        return new Driver();
    }
    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/add")
    public String addDriver(@Valid @ModelAttribute Driver driver, BindingResult result, Model model){
        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();

            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            model.addAttribute("error", result);
            return Mappings.DRIVER_FORM_ADD;
        }else
        driverService.insertOrUpdate(driver);
        return "redirect:/driver";

    }

    @GetMapping()
    public String menuDriver(Model model){
        List<Driver> drivers = driverService.getAll();
        model.addAttribute("drivers",drivers);
        return Mappings.DRIVER_MENU;
    }
    @GetMapping("/add")
    public String addDriverForm(){
        return Mappings.DRIVER_FORM_ADD;
    }
    @GetMapping("/delete")
    public String deleteDriver(@RequestParam long id){
        driverService.remove(id);
        return "redirect:/driver";

    }

}
