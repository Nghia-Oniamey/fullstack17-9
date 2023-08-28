package com.codingeznghiaxpes.fullstackbackend.service.impl;

import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;
import com.codingeznghiaxpes.fullstackbackend.repository.SubCategoryRepository;
import com.codingeznghiaxpes.fullstackbackend.service.SubCategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllSubCategory() {
        return subCategoryRepository.findAll();
    }
}