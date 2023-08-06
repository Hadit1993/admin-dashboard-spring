package com.hadit1993.admin.dashboard.spring.data.dtos;


import com.hadit1993.admin.dashboard.spring.data.entities.Role;
import com.hadit1993.admin.dashboard.spring.data.entities.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String city;
    private String state;
    private String country;
    private String occupation;
    private String phoneNumber;
    private List<String> transactions;
    private Role role;

    public static UserDto fromEntity(UserEntity userEntity) {

        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getCity(),
                userEntity.getState(),
                userEntity.getCountry(),
                userEntity.getOccupation(),
                userEntity.getPhoneNumber(),
                userEntity.getTransactions(),
                userEntity.getRole()
        );
    }
}
