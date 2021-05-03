package spring.project.superfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.project.superfood.models.Product;
import spring.project.superfood.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String buyFood(Model model) {
        List<Product> productList = productService.getProduct();
        model.addAttribute("food", productList);
        return "product";
    }
}
