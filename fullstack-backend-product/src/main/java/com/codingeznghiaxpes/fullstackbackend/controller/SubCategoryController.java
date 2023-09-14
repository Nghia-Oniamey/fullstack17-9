package com.codingeznghiaxpes.fullstackbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codingeznghiaxpes.fullstackbackend.service.SubCategoryService;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/sub-category")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    public List<SubCategory> getAllSubCategoryController(){
        return subCategoryService.getAllSubCategory();
    }

}
