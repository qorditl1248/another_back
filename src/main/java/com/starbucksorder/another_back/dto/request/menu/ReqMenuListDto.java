package com.starbucksorder.another_back.dto.request.menu;

import lombok.Data;

@Data
public class ReqMenuListDto {
    private Long categoryId;
    private Long page;
    private Long limit;
}
