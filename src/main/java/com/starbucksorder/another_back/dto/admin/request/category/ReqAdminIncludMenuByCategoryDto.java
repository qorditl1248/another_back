package com.starbucksorder.another_back.dto.admin.request.category;

import lombok.Data;

import java.util.List;

@Data
public class ReqAdminIncludMenuByCategoryDto {
    private Long categoryId;
    private List<Long> menuIds;
}
