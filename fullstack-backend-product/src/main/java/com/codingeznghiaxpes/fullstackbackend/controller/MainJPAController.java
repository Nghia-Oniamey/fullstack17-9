package com.codingeznghiaxpes.fullstackbackend.controller;

import com.codingeznghiaxpes.fullstackbackend.model.Product;
import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;
import com.codingeznghiaxpes.fullstackbackend.model.Status;
import com.codingeznghiaxpes.fullstackbackend.service.ProductService;
import com.codingeznghiaxpes.fullstackbackend.service.BrandService;
import com.codingeznghiaxpes.fullstackbackend.service.StatusService;
import com.codingeznghiaxpes.fullstackbackend.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/service")
public class MainJPAController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/products")
    public List<Product> showProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product, id);
    }

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable Long id) {
        return productService.showDetailProduct(id);
    }


    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/products/api/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Double sellPrice,
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long subCategoryId,
            @RequestParam(required = false) Long statusId
    ) {
        Brand brand = brandService.getBrandById(brandId);
        Status status = statusService.getStatusById(statusId);
        SubCategory subCategory = subCategoryService.getSubCateById(subCategoryId);
        if (productName != null && !productName.trim().isEmpty() && sellPrice != null) {
            return productService.searchProductsFull(productName, sellPrice, brand, subCategory, status);
        } else if (productName != null && !productName.trim().isEmpty()) {
            return productService.searchProductsWithName(productName, brand, subCategory, status);
        } else if (sellPrice != null) {
            return productService.searchProductWithSellPrice(sellPrice, brand, subCategory, status);
        } else {
            return productService.searchProducts(brand, subCategory, status);
        }
    }

    @GetMapping("/products/api/search2")
    public List<Product> searchProducts2(
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Double sellPrice,
            @RequestParam(required = false) Long brandId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long statusId
    ) {
        return productService.searchProductWithProperty(
                productName,
                sellPrice,
                brandId,
                categoryId,
                statusId
        );
    }
}
