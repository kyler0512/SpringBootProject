package spring.project.superfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.project.superfood.models.Product;
import spring.project.superfood.models.User;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductsById(Integer id);

    void deleteById(Integer id);

    List<Product> findAllByUser(User user);


}
