package com.hadit1993.admin.dashboard.spring.data.dtos;

import com.hadit1993.admin.dashboard.spring.data.entities.TransactionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionDto {

    public TransactionDto(TransactionEntity transactionEntity) {
        this.id = transactionEntity.getId();
        this.userId = transactionEntity.getUserId();
        this.cost = transactionEntity.getCost();
        this.products = transactionEntity.getProducts().stream().map(ObjectId::toString).toList();
        this.createdAt = transactionEntity.getCreatedAt();
        this.updatedAt = transactionEntity.getUpdatedAt();

    }

    private String id;

    private String userId;

    private float cost;

    private List<String> products;


    private Date createdAt;


    private Date updatedAt;


}
