package com.codingeznghiaxpes.fullstackbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sub_cate_code", length = 20, nullable = false)
    private String subCateCode;

    @Column(name = "sub_cate_name", length = 50, nullable = false)
    private String subCateName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
