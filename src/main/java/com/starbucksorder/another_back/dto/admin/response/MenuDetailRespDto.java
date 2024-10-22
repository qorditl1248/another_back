package com.starbucksorder.another_back.dto.admin.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuDetailRespDto {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private String comment;
    // 추후 추가예정
    @JsonIgnore
    private Long menuStatus;
    private String imgUrl;
    private String options;
    private String categories;
}
