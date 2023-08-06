package com.hadit1993.admin.dashboard.spring.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hadit1993.admin.dashboard.spring.data.dtos.*;
import com.hadit1993.admin.dashboard.spring.data.entities.TransactionEntity;
import com.hadit1993.admin.dashboard.spring.data.entities.UserEntity;
import com.hadit1993.admin.dashboard.spring.services.ClientService;
import com.hadit1993.admin.dashboard.spring.validation.ValidObjectId;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ClientService clientService;

    @GetMapping("/products")
    public ResponseEntity<BaseResponse<List<ProductWithStat>>> getProducts() {

        return BaseResponse
                .<List<ProductWithStat>>builder()
                .data(clientService.getProductsWithStats())
                .build().convertToResponse();
    }

    @GetMapping("/customers")
    public ResponseEntity<BaseResponse<List<UserDto>>> getCustomers() {

        var users = clientService.getCustomers().stream().map(UserDto::fromEntity).toList();
        return BaseResponse.<List<UserDto>>builder().data(users).build().convertToResponse();
    }

    @GetMapping("/transactions")
    public ResponseEntity<BaseResponse<Paginate<TransactionDto>>> getTransactions(
            @RequestParam(defaultValue = "1", required = false) @Min(1) Integer page,
            @RequestParam(defaultValue = "20", required = false) @Min(10) Integer pageSize,
            @RequestParam(defaultValue = "id-asc", required = false) String sort,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) @Min(0) Float minCost,
            @RequestParam(required = false) @Min(0) Float maxCost
    ) {

        var entityData = clientService.getTransactions(
                page, pageSize, sort, userId, minCost, maxCost
        );

        var transformedData = new Paginate<>(
                entityData.getData().stream().map(TransactionDto::new).toList(),
                entityData.getTotalPages(),
                entityData.getTotalElements(),
                entityData.getPageSize(),
                entityData.getCurrentPage(),
                entityData.getSort()
        );


        return BaseResponse.<Paginate<TransactionDto>>builder().data(transformedData).build().convertToResponse();
    }


//    @GetMapping("/submit")
//    public ResponseEntity<BaseResponse<Object>> submit() throws IOException {
//
//        Resource resource = resourceLoader.getResource("classpath:static/data.json");
//        var objectMapper = new ObjectMapper();
//        Data data = objectMapper.readValue(resource.getInputStream(), Data.class);
//        var result = clientService.addAllTransactions(data.getDataTransaction());
//        return ResponseEntity.ok(BaseResponse.builder().data(result).build());
//    }

}
