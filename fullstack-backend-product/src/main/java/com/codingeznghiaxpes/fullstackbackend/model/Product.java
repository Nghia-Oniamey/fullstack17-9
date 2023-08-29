package com.codingeznghiaxpes.fullstackbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(ProductPK.class)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName;

    @Column(name = "color", length = 50, nullable = false)
    private String color;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "sell_price", nullable = false)
    private Double sellPrice;

    @Column(name = "origin_price", nullable = false)
    private Double originPrice;

    @Column(name = "description", nullable = true, length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "product_brand",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private List<Brand> brands;

}
