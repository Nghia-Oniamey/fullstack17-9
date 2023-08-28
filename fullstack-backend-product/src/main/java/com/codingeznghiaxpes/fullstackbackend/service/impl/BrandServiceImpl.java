package com.codingeznghiaxpes.fullstackbackend.service.impl;

import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import com.codingeznghiaxpes.fullstackbackend.repository.BrandRepository;
import com.codingeznghiaxpes.fullstackbackend.service.BrandService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }
}
