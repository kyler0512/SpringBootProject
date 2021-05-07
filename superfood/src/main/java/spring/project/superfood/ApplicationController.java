package spring.project.superfood;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring.project.superfood.models.User;

import java.security.Security;

@Controller
public class ApplicationController {
    @GetMapping(value = "/index")
    public String goHome() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        User user = getPrincipal();
        if (user != null) {
            return "index";
        }
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {return "login"; }

    public User getPrincipal() {
        User user = null;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        return user;
    }
    @GetMapping(value = "/register")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "register";
    }
    @GetMapping(value = "/contact")
    public String goContact() {
        return "contact";
    }
    @GetMapping(value = "/about")
    public String goAbout() {
        return "about";
    }
}
