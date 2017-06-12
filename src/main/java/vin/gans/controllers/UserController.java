package vin.gans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vin.gans.domain.User;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Created by root on 10.05.17.
 */
@Controller
public class UserController {


    @RequestMapping(value = "/login")
    public String getLoginPage (@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout,
                                Model model){
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }


}
