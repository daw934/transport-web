package pl.transport.transportapp.controllerRest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.transport.transportapp.model.dto.JourneyOrderDto;
import pl.transport.transportapp.model.journey.JourneyOrder;
import pl.transport.transportapp.serviceNew.CarService;
import pl.transport.transportapp.serviceNew.CurrencyService;
import pl.transport.transportapp.serviceNew.DriverService;
import pl.transport.transportapp.serviceNew.JourneyOrderServiceNew;

import java.util.List;

@RestController
@RequestMapping(path = "api/journeyorder")
public class JourneyControllerRest {

    private JourneyOrderServiceNew journeyService;

    private CarService carService;

    private DriverService driverService;


    @Autowired
    private CurrencyService currencyService;

    @ModelAttribute
    public JourneyOrderDto journeyOrderView() {
        return new JourneyOrderDto();
    }


    @Autowired
    public JourneyControllerRest(JourneyOrderServiceNew journeyService, CarService carService, DriverService driverService) {
        this.journeyService = journeyService;
        this.carService = carService;
        this.driverService = driverService;
    }

    @GetMapping
    public List<JourneyOrder> getJourneyOrders() {
        return journeyService.getAll();
    }

    @GetMapping("/{id]")
    public JourneyOrder getJourneyOrder(@PathVariable long id) {
        return journeyService.get(id);
    }

    @PostMapping
    public void addJourney(@RequestBody JourneyOrder journeyOrder) {
        journeyService.add(journeyOrder);
    }
}

