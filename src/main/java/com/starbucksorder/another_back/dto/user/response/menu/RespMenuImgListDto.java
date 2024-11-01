package com.starbucksorder.another_back.dto.user.response.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespMenuImgListDto {
    private Long menuId;
    private String imgUrl;
}
