package com.hadit1993.admin.dashboard.spring.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SortModel {

    private String sortBy;

    private String sortDir;
}
