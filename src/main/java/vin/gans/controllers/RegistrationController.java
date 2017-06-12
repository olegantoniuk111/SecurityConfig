package vin.gans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import vin.gans.customExeptions.EmailExistExeption;
import vin.gans.domain.User;
import vin.gans.domain.UserDto;
import vin.gans.services.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegisterforn(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "registerForm";
    }

    @RequestMapping(value = "/registerForm", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                                        BindingResult result, WebRequest webRequest, Errors error) {
        User registeredUser = new User();
        if (!result.hasErrors()) {
            registeredUser = userService.createNewUserAccount(userDto);
        }
        if (registeredUser == null) {
            result.reject("email", "such email exists");
        }
        if (result.hasErrors()) {
               return new ModelAndView("registerForm", "userDto", userDto);

            } else {
            return new ModelAndView("regPage", "user", registeredUser);
            }
    }

    private User createNewUserAccount(UserDto userDto, BindingResult bindingResult){
        User registeredUser = null;
        try{
            registeredUser = userService.createNewUserAccount(userDto);
        }catch (EmailExistExeption emailExistExeption){
            return null;
        }
        return registeredUser;
    }
}
