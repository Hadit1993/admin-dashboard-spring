package com.hadit1993.admin.dashboard.spring.services;

import com.hadit1993.admin.dashboard.spring.data.dtos.Paginate;
import com.hadit1993.admin.dashboard.spring.data.dtos.ProductWithStat;
import com.hadit1993.admin.dashboard.spring.data.entities.*;
import com.hadit1993.admin.dashboard.spring.repositories.ProductRepository;
import com.hadit1993.admin.dashboard.spring.repositories.ProductStatRepository;
import com.hadit1993.admin.dashboard.spring.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductStatRepository productStatRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<ProductWithStat> getProductsWithStats() {

        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductWithStat> productWithStats = new ArrayList<>();
        for (ProductEntity product : productEntities) {
            Query query = new Query();
            query.addCriteria(Criteria.where("productId").is(product.getId()));
            ProductStatEntity productStat = mongoTemplate.findOne(query, ProductStatEntity.class);
            productWithStats.add(new ProductWithStat(product, productStat));
        }

        return productWithStats;
    }

    public List<UserEntity> getCustomers() {
        Query query = new Query();
        query.addCriteria(Criteria.where("role").is(Role.user));
        List<UserEntity> users = mongoTemplate.find(query, UserEntity.class);
        return users;

    }

    public Paginate<TransactionEntity> getTransactions(
            Integer page,
            Integer pageSize,
            String sort, String userId,
            Float minCost,
            Float maxCost) {

        String sortKey = "id";
        String sortDir = "asc";
        if (sort != null) {
            String[] sortSections = sort.split("-");
            if (sortSections.length == 2) {
                sortKey = sortSections[0];
                sortDir = sortSections[1];
            }
        }
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();
        if (userId != null) {
            criteria.add(Criteria.where("userId").regex(userId));
        }
        if (minCost != null && maxCost != null) {
            criteria.add(Criteria.where("cost").gte(minCost).lte(maxCost));
        } else if (minCost != null) {
            criteria.add(Criteria.where("cost").gte(minCost));
        } else if (maxCost != null) {
            criteria.add(Criteria.where("cost").lte(maxCost));
        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }

        var sortDirection = sortDir.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        var pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(sortDirection, sortKey));
        long total = mongoTemplate.count(query, TransactionEntity.class);
        query.with(pageRequest);
        var transactions = mongoTemplate.find(query, TransactionEntity.class);

        var pageImpl = new PageImpl<>(transactions, pageRequest, total);

        return new Paginate<>(pageImpl);


    }


//    public List<TransactionEntity> addAllTransactions(List<TransactionEntity> transactions) {
//
//        transactionRepository.saveAll(transactions);
//
//
//       return transactions;
//
//    }
}
