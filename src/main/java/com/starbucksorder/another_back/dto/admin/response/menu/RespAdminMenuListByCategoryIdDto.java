package com.starbucksorder.another_back.dto.admin.response.menu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAdminMenuListByCategoryIdDto {
    private Long menuId;
    private String menuName;

}
