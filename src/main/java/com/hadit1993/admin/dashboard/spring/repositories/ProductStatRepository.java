package com.hadit1993.admin.dashboard.spring.repositories;

import com.hadit1993.admin.dashboard.spring.data.entities.ProductEntity;
import com.hadit1993.admin.dashboard.spring.data.entities.ProductStatEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStatRepository extends MongoRepository<ProductStatEntity, String> {
}
