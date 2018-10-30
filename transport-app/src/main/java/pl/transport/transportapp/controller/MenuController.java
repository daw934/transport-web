package pl.transport.transportapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.transport.transportapp.util.Mappings;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String carMenu(){
        System.out.println("idzie");
        return Mappings.CAR_MENU;
    }

}
