package pl.transport.transportapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.transport.transportapp.model.car.Car;
import pl.transport.transportapp.model.currency.Currency;
import pl.transport.transportapp.model.driver.Driver;
import pl.transport.transportapp.model.dto.JourneyOrderDto;
import pl.transport.transportapp.model.journey.JourneyOrder;
import pl.transport.transportapp.serviceNew.CarService;
import pl.transport.transportapp.serviceNew.CurrencyService;
import pl.transport.transportapp.serviceNew.DriverService;
import pl.transport.transportapp.serviceNew.JourneyOrderServiceNew;
import pl.transport.transportapp.util.AtributesName;
import pl.transport.transportapp.util.Mappings;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "journeyorder")
public class JourneyController {

    private JourneyOrderServiceNew journeyService;

    private pl.transport.transportapp.serviceNew.CarService carService;

    private pl.transport.transportapp.serviceNew.DriverService driverService;


    @Autowired
    private CurrencyService currencyService;
    @ModelAttribute
    public JourneyOrderDto journeyOrderView(){
        return new JourneyOrderDto();
    }

    @Autowired
    public JourneyController(JourneyOrderServiceNew journeyService, CarService carService, DriverService driverService) {
        this.journeyService = journeyService;
        this.carService = carService;
        this.driverService = driverService;
    }

    @GetMapping
    public String getMainJourneyPage(Model model){
        List<JourneyOrder> journeyOrders = journeyService.getAll();
        model.addAttribute("journeyList",journeyOrders);
        return Mappings.JOURNEY_MAIN_PAGE;
    }
    @GetMapping("/delete")
    public String deleteItem(@RequestParam long id){
        journeyService.remove(id);
        return "redirect:/journeyorder";
    }
    @GetMapping("/add")
    public String insertForm(Model model){
        List<JourneyOrder> journeyOrders = journeyService.getAll();
        model.addAttribute("journeyList",journeyOrders);
        Currency currency = currencyService.getEuro();
        model.addAttribute("currency", currency);
        return Mappings.JOURNEY_FORM_ADD;
    }

    @PostMapping("/add")
    public String insertItem(@Valid @ModelAttribute(AtributesName.JOURNEY_VIEW) JourneyOrderDto journeyOrderDto,
                             BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
                redirectAttributes.addFlashAttribute("error",result);
                return "redirect:/journeyorder/add";
        }


        Driver driver = driverService.find(journeyOrderDto.getDriverLastName());
        Car car = carService.findCar(journeyOrderDto.getCarPlate());

        if (car == null || driver ==null){
            if(car == null)
                result.rejectValue("carPlate", "carPlate", "Car not exist in db");
            if(driver == null)
                result.rejectValue("driverLastName","driverLastName", "Driver not exist in db");
        }else {
            JourneyOrder journeyOrder = new JourneyOrder();
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
            try {
                Date date = dateFormat.parse(journeyOrderDto.getDate());
                journeyOrder.setDate(date);
                journeyOrder.setCar(car);
                journeyOrder.setDriver(driver);
                journeyOrder.setDestination(journeyOrderDto.getDestination());
                journeyService.add(journeyOrder);
                return "redirect:/journeyorder";
            }catch (ParseException e){
                result.rejectValue("date","date","Wrong date format, try \"year-month-day\"");
            }
        }
        System.out.println("koniec");

//        model.addAttribute("error", result);
        redirectAttributes.addFlashAttribute("error",result);
        return "redirect:/journeyorder/add";

        }
    }

