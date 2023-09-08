package com.codingeznghiaxpes.fullstackbackend.service;

import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrand();

    Brand getBrandById(Long id);

}
