package com.codingeznghiaxpes.fullstackbackend.service.impl;

import com.codingeznghiaxpes.fullstackbackend.exception.ProductNotFoundException;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;
import com.codingeznghiaxpes.fullstackbackend.repository.SubCategoryRepository;
import com.codingeznghiaxpes.fullstackbackend.service.SubCategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllSubCategory() {
        return subCategoryRepository.findAll();
    }

    @Transactional
    @Override
    public SubCategory getSubCateById(Long id) {
        if (id == null) {
            return null;
        }
        return subCategoryRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
