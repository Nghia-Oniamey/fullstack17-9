package com.codingeznghiaxpes.fullstackbackend.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindProductsRequest {

    private String productName;

    private Double sellPrice;

    private Long brandId;

    private Long CategoryId;

    private Long statusId;

}
