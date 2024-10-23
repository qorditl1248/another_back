package com.starbucksorder.another_back.dto.admin.response.menu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAdminMenuList {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private String categories;
    private String options;

    @Data
    @Builder
    public static class MenuAdminDetailRespDto {
        private Long menuId;
        private String menuName;
        private int menuPrice;
        private String comment;
        private Long menuStatus;
        private String imgUrl;
        private String options;
        private String categories;
    }
}