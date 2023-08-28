//package com.codingeznghiaxpes.fullstackbackend.convert;
//
//import com.codingeznghiaxpes.fullstackbackend.model.Product;
//import com.codingeznghiaxpes.fullstackbackend.response.ProductResponse;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductConvert {
//
//    private ProductResponse productResponse;
//    private Product product;
//
//    public ProductResponse setProductResponse(Product product) throws Exception{
//        productResponse = new ProductResponse();
//        productResponse.setProductId(product.getId());
//        productResponse.setProductName(product.getProductName());
//        productResponse.setProductColor(product.getColor());
//        productResponse.setDescription(product.getDescription());
//        productResponse.setOriginPrice(product.getOriginPrice());
//        productResponse.setSellPrice(product.getSellPrice());
//        productResponse.setQuantity(product.getQuantity());
//        if(!(product.getBrands().isEmpty())){
//            productResponse.setBrandId(product.getBrands().get(0).getId());
//        }
//
//        return productResponse;
//    }
//}
//
