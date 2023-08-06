package com.hadit1993.admin.dashboard.spring.data.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hadit1993.admin.dashboard.spring.data.entities.ProductEntity;
import com.hadit1993.admin.dashboard.spring.data.entities.ProductStatEntity;
import com.hadit1993.admin.dashboard.spring.data.entities.TransactionEntity;
import com.hadit1993.admin.dashboard.spring.data.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Data {

    @JsonIgnore
    private List dataAffiliateStat;

    @JsonIgnore
    private List dataOverallStat;

    @JsonIgnore
    private List<ProductEntity> dataProduct;

    @JsonIgnore
    private List<ProductStatEntity> dataProductStat;


    private List<TransactionEntity> dataTransaction;

    @JsonIgnore
    private List<UserEntity> dataUser;
}
