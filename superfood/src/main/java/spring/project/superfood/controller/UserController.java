package spring.project.superfood.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.project.superfood.models.User;
import spring.project.superfood.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public String save(@Valid User user, BindingResult bindingResult, RedirectAttributes ra) {

        if (userService.userExists(user.getEmail()))
            bindingResult.addError(new FieldError("user", "email", "Email address is already taken"));

        if (bindingResult.hasErrors())
            return "register";

        ra.addFlashAttribute("message", "Register successfully! Now you can login to the website");
        userService.save(user);
        return "redirect:/login";
    }
//    @PostMapping("/login")
//    public String checkLogin(@Valid User user) {
//        if (userService.userExists())
//    }
}
