package com.starbucksorder.another_back.dto.user.response.menu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespMenuListAll {
    private Long menuId;
    private String menuName;
}
