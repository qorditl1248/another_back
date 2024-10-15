package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    private Long categoryId;
    private String categoryName;
    private Long categoryStatus;
    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;

    private List<Menu> menuList;
}
