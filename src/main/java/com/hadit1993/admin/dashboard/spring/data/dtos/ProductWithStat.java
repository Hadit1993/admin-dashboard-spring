package com.hadit1993.admin.dashboard.spring.data.dtos;

import com.hadit1993.admin.dashboard.spring.data.entities.ProductEntity;
import com.hadit1993.admin.dashboard.spring.data.entities.ProductStatEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductWithStat {
    private ProductEntity product;
    private ProductStatEntity productStat;
}
