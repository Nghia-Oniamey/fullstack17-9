package com.codingeznghiaxpes.fullstackbackend.repository;

import com.codingeznghiaxpes.fullstackbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
