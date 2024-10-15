package com.starbucksorder.another_back.dto.response.menu;

import com.starbucksorder.another_back.entity.Menu;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Builder
@Data
public class RespMenuListDto {
    private Long menuId;
    private Long categoryId;
    private String menuName;
    private Double menuPrice;


    ArrayList<RespMenuListDto> menuList;
}