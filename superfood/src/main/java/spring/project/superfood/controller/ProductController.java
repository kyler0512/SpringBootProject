package spring.project.superfood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.project.superfood.models.Product;
import spring.project.superfood.models.User;
import spring.project.superfood.service.ProductService;
import spring.project.superfood.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @GetMapping("/product")
    public String buyFood(Model model) {
        model.addAttribute("food", productService.getProduct());
        return "product";
    }
    @GetMapping("/mystore")
    public String myStore(Model model) {
        model.addAttribute("myProduct", productService.findByUser(getUser()));
        return "mystore";
    }

    @PostMapping("/mystore")
    public String addProduct(Product product) {
        product.setUser(getUser());
        productService.save(product);
        return "redirect:/mystore";
    }
    @RequestMapping(value = "/mystore/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
        return "mystore";
    }
    @RequestMapping(value = "/mystore/edit{id}", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("newProduct", product);
        return "editproduct";
    }
    @RequestMapping(value = "/mystore/save", method = RequestMethod.POST)
    public String saveNewProduct(Product product) {
        productService.save(product);
        return "redirect:/mystore";
    }
}
