package com.hadit1993.admin.dashboard.spring.repositories;

import com.hadit1993.admin.dashboard.spring.data.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface UserRepository extends MongoRepository<UserEntity, String> {
}
