package spring.project.superfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.project.superfood.models.Product;
import spring.project.superfood.models.User;
import spring.project.superfood.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findProductsById(id);
    }

    public List<Product> findAllbyUser(User user) {
        return productRepository.findAllByUser(user);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
    public List<Product> findByUser(User user) {
        return productRepository.findAllByUser(user);
    }

    @Transactional
    public void updateProduct(Integer id,
                              String name,
                              String type,
                              String description,
                              double price) {
        Product product = findById(id);
        product.setProductName(name);
        product.setProductType(type);
        product.setDescription(description);
        product.setPrice(price);
        final Product saveProduct = productRepository.save(product);
    }
}
