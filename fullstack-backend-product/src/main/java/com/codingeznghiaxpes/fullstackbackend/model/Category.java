package com.codingeznghiaxpes.fullstackbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(ProductPK.class)
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cate_code", length = 20, nullable = false)
    private String cateCode;

    @Column(name = "cate_name", length = 50, nullable = false)
    private String cateName;

}
