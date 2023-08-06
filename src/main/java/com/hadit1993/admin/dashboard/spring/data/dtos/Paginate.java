package com.hadit1993.admin.dashboard.spring.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Paginate<T> {


    public Paginate(Page<T> page) {
        this.data = page.getContent();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.pageSize = page.getSize();
        this.currentPage = page.getNumber() + 1;
        this.sort = new ArrayList<>();

        page.getPageable().getSort().forEach(order -> {
            sort.add(new SortModel(order.getProperty(), order.getDirection().name()));
        });
    }

   private List<T> data;

   private Integer totalPages;

   private Long totalElements;

   private Integer pageSize;

   private Integer currentPage;

   private List<SortModel> sort;

}
