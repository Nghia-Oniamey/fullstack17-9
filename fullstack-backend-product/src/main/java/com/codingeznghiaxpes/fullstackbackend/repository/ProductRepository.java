package com.codingeznghiaxpes.fullstackbackend.repository;

import com.codingeznghiaxpes.fullstackbackend.model.Product;
import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;
import com.codingeznghiaxpes.fullstackbackend.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductNameContainingAndSellPriceAndBrandsAndSubCategoryAndStatus(String productName,
                                                                                          Double sellPrice,
                                                                                          Brand brand,
                                                                                          SubCategory ubCate,
                                                                                          Status status);

    List<Product> findByProductNameContainingAndBrandsAndSubCategoryAndStatus(String productName,
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

    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN p.brands b " +
            "WHERE (:productName IS NULL OR p.productName LIKE %:productName%) " +
            "AND (:sellPrice IS NULL OR p.sellPrice = :sellPrice) " +
            "AND (:subCateId IS NULL OR p.subCategory.id = :subCateId) " +
            "AND (:statusId IS NULL OR p.status.id = :statusId) " +
            "AND (:brandId IS NULL OR b.id = :brandId)")
    List<Product> searchProducts(
            String productName,
            Double sellPrice,
            Long brandId,
            Long subCateId,
            Long statusId
    );


}
