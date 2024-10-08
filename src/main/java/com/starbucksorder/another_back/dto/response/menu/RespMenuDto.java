package com.starbucksorder.another_back.dto.response.menu;

import com.starbucksorder.another_back.entity.Menu;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Builder
@Data
public class RespMenuDto {
//    private Long menuId;
//    private String menuName;
//    private String comment;
//    private String price;
//    private String url;
    Set<Menu> menu;

}
