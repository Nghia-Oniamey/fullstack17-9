package com.codingeznghiaxpes.fullstackbackend.service;

import com.codingeznghiaxpes.fullstackbackend.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product saveProduct(Product product);

    Product updateProduct(Product product, Long id);

    String deleteProduct(Long id);

    Product showDetailProduct(Long id);

}
