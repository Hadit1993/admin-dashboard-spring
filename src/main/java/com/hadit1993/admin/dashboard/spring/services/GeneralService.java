package com.hadit1993.admin.dashboard.spring.services;

import com.hadit1993.admin.dashboard.spring.data.entities.UserEntity;
import com.hadit1993.admin.dashboard.spring.repositories.UserRepository;
import com.hadit1993.admin.dashboard.spring.utils.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("No user found with id " + userId));
    }

//    public void saveAllUsers(List<UserEntity> users) {
//        userRepository.saveAll(users);
//    }
}
