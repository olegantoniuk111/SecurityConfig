package vin.gans.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vin.gans.domain.User;
import java.util.Collection;

@Controller
public class TestController{
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public String testMethod(Model model){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        User userDetails = (User) auth.getPrincipal();
        String userName = userDetails.getUsername();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
        model.addAttribute("username", userName);
        model.addAttribute("roles", roles);
        return "testPage";
    }

}
