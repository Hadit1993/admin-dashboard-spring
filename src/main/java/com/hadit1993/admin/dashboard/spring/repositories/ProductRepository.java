package com.hadit1993.admin.dashboard.spring.repositories;

import com.hadit1993.admin.dashboard.spring.data.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
