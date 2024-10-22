package com.starbucksorder.another_back.dto.admin;

import com.starbucksorder.another_back.entity.Menu;
import lombok.*;

import java.util.List;

public class MenuDto {

    // save
    @Data
    public static class ReqDto {
        private String menuName;
        private int menuPrice;
        private String comment;
        private Long menuStatus;
        private String imgUrl;

        // 옵션 추가를 위한 것
        private List<Long> optionIds;

        public Menu toMenuEntity() {
            return Menu.builder()
                    .menuName(menuName)
                    .menuPrice(menuPrice)
                    .comment(comment)
                    .menuStatus(menuStatus)
                    .imgUrl(imgUrl)
                    .build();
        }
    }

    @Data
    public static class adminMenuDto {
        private Long page;
        private Long limit;
        private String searchName;
    }
    @Data
    @Builder
    @AllArgsConstructor
    public static class CMRespDto<T> {
        private int totalCount;
        private T data;
    }

    @Data
    @Builder
    public static class RespMenuList {
        private Long menuId;
        private String menuName;
        private int menuPrice;
        private String categories;
        private String options;

    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class CMRespCategoryAndOption {
        private List<RespOptions> options;
        private List<RespCategories> categories;
    }

    @Data
    @Builder
    public static class RespCategories {
        private Long categoryId;
        private String categoryName;
    }
    @Data
    @Builder
    public static class RespOptions {
        private Long optionId;
        private String optionName;
    }
}