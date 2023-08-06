package com.hadit1993.admin.dashboard.spring.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.hadit1993.admin.dashboard.spring.data.dtos.DailyData;
import com.hadit1993.admin.dashboard.spring.data.dtos.MonthlyData;
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
import java.util.List;

@Document("productStats")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductStatEntity implements Persistable<String> {
    @Id
    @JsonSetter("_id")
    private String id;
    private String productId;
    private Integer yearlySalesTotal;
    private Integer yearlyTotalSoldUnits;
    private Integer year;
    private List<MonthlyData> monthlyData;
    private List<DailyData> dailyData;


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
