package com.codingeznghiaxpes.fullstackbackend.service;

import com.codingeznghiaxpes.fullstackbackend.model.Product;
import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import com.codingeznghiaxpes.fullstackbackend.model.Status;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product saveProduct(Product product);

    Product updateProduct(Product product, Long id);

    String deleteProduct(Long id);

    Product showDetailProduct(Long id);

    List<Product> searchProducts(Brand brand,
                                SubCategory subCate,
                                Status status);

    List<Product> searchProductsFull(String productName,
                                     Double sellPrice,
                                     Brand brand,
                                     SubCategory subCate,
                                     Status status);

    List<Product> searchProductsWithName(String productName,
                                         Brand brand,
                                         SubCategory subCate,
                                         Status status);

    List<Product> searchProductWithSellPrice(Double sellPrice,
                                             Brand brand,
                                             SubCategory subCate,
                                             Status status);
}
