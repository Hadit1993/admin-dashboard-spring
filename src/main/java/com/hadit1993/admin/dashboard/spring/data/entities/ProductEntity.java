package com.hadit1993.admin.dashboard.spring.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("products")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity implements Persistable<String> {
    @Id
    @JsonSetter("_id")
    private String id;
    private String name;
    private Long price;
    private String description;
    private String category;
    private Float rating;
    private Integer supply;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @Version
    private Long version;


    @JsonIgnore
    @Override
    public boolean isNew() {
        return version == null;
    }
}
