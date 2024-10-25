package com.starbucksorder.another_back.dto.admin.response.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAdminCategoryDto {

    private Long categoryId;
    private String categoryName;
    private Long categoryStatus;
    private int categorySeq;
}
