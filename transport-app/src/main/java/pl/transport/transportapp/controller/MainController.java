package pl.transport.transportapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.transport.transportapp.util.Mappings;

@Controller
public class MainController {


    @RequestMapping("/")
    public String mainWindow(){
        return Mappings.MAIN_PAGE;
    }
//    @GetMapping("/loginpage")
//    public String login(){
//        return "login";
//    }
}
