package com.codingeznghiaxpes.fullstackbackend.repository;

import com.codingeznghiaxpes.fullstackbackend.model.Product;
import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;
import com.codingeznghiaxpes.fullstackbackend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContainingAndBrandsAndSubCategoryAndStatus(String productName,
                                                                                      Brand brand,
                                                                                      SubCategory ubCate,
                                                                                      Status status);

    List<Product> findByProductNameContainingAndSellPriceAndBrandsAndSubCategoryAndStatus(String productName,
                                                                                      Double sellPrice,
                                                                                      Brand brand,
                                                                                      SubCategory ubCate,
                                                                                      Status status);

    List<Product> findBySellPriceAndBrandsAndSubCategoryAndStatus(Double sellPrice,
                                                                  Brand brand,
                                                                  SubCategory ubCate,
                                                                  Status status);

    List<Product> findByBrandsAndSubCategoryAndStatus(Brand brand,
                                                      SubCategory ubCate,
                                                      Status status);

}
