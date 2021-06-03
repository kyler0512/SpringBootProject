package spring.project.superfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.project.superfood.models.Payment;
import spring.project.superfood.models.User;
import spring.project.superfood.service.PaymentService;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @RequestMapping("/payment")
    public String buy(@RequestParam("productName") String name, @RequestParam("price") Float price, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        return "payment";
    }

    @PostMapping("/payment/confirm")
    public String confirmBuy(Payment payment) {
        paymentService.savePayment(payment);
        return "confirm";
    }
}
