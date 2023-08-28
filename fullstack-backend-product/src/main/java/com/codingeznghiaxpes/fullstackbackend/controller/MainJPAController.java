package com.codingeznghiaxpes.fullstackbackend.controller;

import com.codingeznghiaxpes.fullstackbackend.model.Product;
import com.codingeznghiaxpes.fullstackbackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/service")
public class MainJPAController {

    @Autowired
    private ProductService productService;

    private Product product;

    @GetMapping("/products")
    public List<Product> showProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product, id);
    }

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable Long id) {
        return productService.showDetailProduct(id);
    }


    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
