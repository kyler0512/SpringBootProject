package spring.project.superfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.project.superfood.models.Payment;
import spring.project.superfood.models.Product;
import spring.project.superfood.models.User;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
