package com.codingeznghiaxpes.fullstackbackend.service.impl;

import com.codingeznghiaxpes.fullstackbackend.exception.ProductNotFoundException;
import com.codingeznghiaxpes.fullstackbackend.model.Brand;
import com.codingeznghiaxpes.fullstackbackend.model.Product;
import com.codingeznghiaxpes.fullstackbackend.model.Status;
import com.codingeznghiaxpes.fullstackbackend.model.SubCategory;
import com.codingeznghiaxpes.fullstackbackend.repository.ProductRepository;
import com.codingeznghiaxpes.fullstackbackend.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product newProduct, Long id) {
        return productRepository.findById(id).map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setColor(newProduct.getColor());
            product.setQuantity(newProduct.getQuantity());
            product.setSellPrice(newProduct.getSellPrice());
            product.setOriginPrice(newProduct.getOriginPrice());
            product.setBrands(newProduct.getBrands());
            product.setSubCategory(newProduct.getSubCategory());
            product.setStatus(newProduct.getStatus());
            return productRepository.save(product);
        }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public String deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        return "Product with id: " + id + " has been deleted success.";
    }

    @Override
    public Product showDetailProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        // hàm orElse null để ném ra 1 Excepsiton nếu xảy ra lỗi @Transactional thực hiện Exception
    }

    @Override
    public List<Product> searchProducts(Brand brand,
                                       SubCategory subCate,
                                       Status status) {
        return productRepository.findByBrandsAndSubCategoryAndStatus(
                brand,
                subCate,
                status
        );
    }

    @Override
    public List<Product> searchProductsFull(String productName,
                                        Double sellPrice,
                                        Brand brand,
                                        SubCategory subCate,
                                        Status status) {
        return productRepository.findByProductNameContainingAndSellPriceAndBrandsAndSubCategoryAndStatus(
                productName,
                sellPrice,
                brand,
                subCate,
                status
        );
    }

    @Override
    public List<Product> searchProductsWithName(String productName,
                                                Brand brand,
                                                SubCategory subCate,
                                                Status status) {
        return productRepository.findByProductNameContainingAndBrandsAndSubCategoryAndStatus(
                productName,
                brand,
                subCate,
                status
        );
    }

    @Override
    public List<Product> searchProductWithSellPrice(Double sellPrice,
                                                    Brand brand,
                                                    SubCategory subCate,
                                                    Status status) {
        return productRepository.findBySellPriceAndBrandsAndSubCategoryAndStatus(
                sellPrice,
                brand,
                subCate,
                status
        );
    }


}
