package com.hadit1993.admin.dashboard.spring.repositories;

import com.hadit1993.admin.dashboard.spring.data.entities.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {

    Page<TransactionEntity> findByCostBetweenAndUserId(Float minCost, Float maxCost, String userId, Pageable pageable);
}
