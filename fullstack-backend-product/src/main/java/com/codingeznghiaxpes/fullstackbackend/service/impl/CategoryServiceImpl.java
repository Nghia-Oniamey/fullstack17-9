package com.codingeznghiaxpes.fullstackbackend.service.impl;

import com.codingeznghiaxpes.fullstackbackend.model.Category;
import com.codingeznghiaxpes.fullstackbackend.repository.CategoryRepository;
import com.codingeznghiaxpes.fullstackbackend.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
