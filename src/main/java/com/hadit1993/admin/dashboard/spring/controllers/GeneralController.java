package com.hadit1993.admin.dashboard.spring.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hadit1993.admin.dashboard.spring.data.dtos.BaseResponse;
import com.hadit1993.admin.dashboard.spring.data.dtos.Data;
import com.hadit1993.admin.dashboard.spring.data.dtos.UserDto;
import com.hadit1993.admin.dashboard.spring.data.entities.UserEntity;
import com.hadit1993.admin.dashboard.spring.services.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/general")
public class GeneralController {
    @Autowired
    private GeneralService generalService;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/users/{userId}")
    public ResponseEntity<BaseResponse<UserDto>> getUser(@PathVariable String userId) throws IOException {

//        Resource resource = resourceLoader.getResource("classpath:static/data.json");
//        var objectMapper = new ObjectMapper();
//        Data data = objectMapper.readValue(resource.getInputStream(), Data.class);
//        generalService.saveAllUsers(data.getDataUser());
//        return ResponseEntity.ok(BaseResponse.builder().data(data).build());

        var userEntity = generalService.findUserById(userId);
        return BaseResponse.<UserDto>builder().data(UserDto.fromEntity(userEntity)).build().convertToResponse();
    }


}
