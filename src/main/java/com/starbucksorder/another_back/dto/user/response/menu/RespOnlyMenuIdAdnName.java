package com.starbucksorder.another_back.dto.user.response.menu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespOnlyMenuIdAdnName {
    private Long menuId;
    private String menuName;
}
