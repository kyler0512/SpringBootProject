package spring.project.superfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.project.superfood.models.Payment;
import spring.project.superfood.models.User;
import spring.project.superfood.service.PaymentService;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public String goPayment() {
        return "payment";
    }
    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @PostMapping(value = "/payment")
    public String addPayment(Payment payment) {
        User user = getUser();
        payment.setName(user.getName());
        payment.setEmail(user.getEmail());
        paymentService.savePayment(payment);
        return "afterpayment";
    }
}
