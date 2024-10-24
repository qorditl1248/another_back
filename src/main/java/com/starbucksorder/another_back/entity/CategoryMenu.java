package com.starbucksorder.another_back.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryMenu {
    private Long menu_categoryId;
    private Long menuId;
    private Long categoryId;
}
