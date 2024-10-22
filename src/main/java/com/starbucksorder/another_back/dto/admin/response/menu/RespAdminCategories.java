package com.starbucksorder.another_back.dto.admin.response.menu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAdminCategories {
    private Long categoryId;
    private String categoryName;
}