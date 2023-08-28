package com.codingeznghiaxpes.fullstackbackend.repository;

import com.codingeznghiaxpes.fullstackbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
