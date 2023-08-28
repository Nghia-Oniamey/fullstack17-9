package com.codingeznghiaxpes.fullstackbackend.repository;

import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
