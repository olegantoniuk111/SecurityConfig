package vin.gans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import vin.gans.domain.User;
import vin.gans.domain.UserDto;
import vin.gans.services.UserService;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterforn(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                                        BindingResult result, WebRequest webRequest, Errors error) {

        User registeredUser = new User();
        if (!result.hasErrors()) {
            registeredUser = userService.createUserAccount(userDto);
        }
        if (registeredUser == null) {
            result.reject("email", "Such email exist's");
        }
        if (result.hasErrors()) {

               return new ModelAndView("register", "userDto", userDto);
            }
        else {
            return new ModelAndView("successregistration", "user", registeredUser);
            }
    }


}
