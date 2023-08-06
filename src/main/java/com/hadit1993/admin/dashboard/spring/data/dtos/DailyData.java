package com.hadit1993.admin.dashboard.spring.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DailyData {
    private String date;
    private Integer totalSales;
    private Integer totalUnits;
}
