package com.hadit1993.admin.dashboard.spring.data.entities;



import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;


@Document("users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity implements Persistable<String> {
    @Id
    @JsonSetter("_id")
    private String id;

    @NotNull
    @Length(min = 2, max = 100)
    private String name;

    @Indexed(unique = true)
    @NotNull
    @Length(max = 50)
    @Email
    private String email;

    @NotNull
    @Length(min = 5)
    private String password;

    private String city;
    private String state;
    private String country;
    private String occupation;
    private String phoneNumber;
    private List<String> transactions;
    private Role role;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @Version
    private Long version;


    @Override
    public boolean isNew() {
        return version == null;
    }
}


