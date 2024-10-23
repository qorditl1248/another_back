package com.starbucksorder.another_back.dto.admin.request.menu;

import com.starbucksorder.another_back.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class ReqAdminModifyDto {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private String imgUrl;
    private String comment;
    private List<Long> optionIds;
    private List<Long> categoryIds;

    public Menu toEntity() {
        return Menu.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .imgUrl(imgUrl)
                .comment(comment)
                .build();
    }
}
