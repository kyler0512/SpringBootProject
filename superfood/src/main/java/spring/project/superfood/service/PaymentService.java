package spring.project.superfood.service;

import org.springframework.stereotype.Service;
import spring.project.superfood.models.Payment;
import spring.project.superfood.repository.PaymentRepository;

@Service
public class PaymentService {
    PaymentRepository paymentRepository;

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

}
