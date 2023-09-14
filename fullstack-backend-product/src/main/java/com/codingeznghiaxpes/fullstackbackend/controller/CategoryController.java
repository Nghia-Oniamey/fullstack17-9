package com.codingeznghiaxpes.fullstackbackend.controller;

import com.codingeznghiaxpes.fullstackbackend.model.Category;
import com.codingeznghiaxpes.fullstackbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategoryController(){
        return categoryService.getAllCategory();
    }

}
