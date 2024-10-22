package com.starbucksorder.another_back.dto.admin.response.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CMRespAdminCategoryAndOption {
    private List<RespAdminOptions> options;
    private List<RespAdminCategories> categories;
}