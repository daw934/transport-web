package pl.transport.transportapp.UserAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public User user(){
        return new User();
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerform";
    }


    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult bindResult, Model model, WebRequest request) {
        if(bindResult.hasErrors()) {
            List<ObjectError> errors = bindResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            model.addAttribute("error",bindResult);
            System.out.println("has a error");
            return "registerform";
        } else if(userService.emailExist(user)) {
            System.out.println("email existByPesel");
            bindResult.rejectValue("email","Email is in use");
            model.addAttribute("error",bindResult);
            return "registerform";
        }else {
            System.out.println("success registration");
            userService.addWithDefaultRole(user);
                String appUrl = request.getContextPath();
                userService.sendRegistrationEmail(user,appUrl);

                return "registersuccess";

        }

    }
    @GetMapping("/registrationConfirm")
    public String confirmRegistration(@RequestParam("token") String token, WebRequest request, Model model){
        System.out.println("halllo");


        VerificationToken vToken = userService.getVerificationToken(token);
        if(vToken == null){
            System.out.println("jest null");
            return "badUser";
        }
        User user = vToken.getUser();

        System.out.println(user.toString());

        user.setEnabled(true);
        System.out.println(user.toString());
        userService.saveRegisteredUser(user);
        return "redirect:/";
    }
}























