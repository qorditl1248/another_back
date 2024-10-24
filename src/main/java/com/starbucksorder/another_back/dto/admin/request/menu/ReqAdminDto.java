package com.starbucksorder.another_back.dto.admin.request.menu;

import com.starbucksorder.another_back.entity.Menu;
import lombok.Data;

import java.util.List;

// save
@Data
public class ReqAdminDto {
    private String menuName;
    private int menuPrice;
    private String comment;
    private Long menuStatus;
    private String imgUrl;

    // 옵션 추가를 위한 것
    private List<Long> optionIds;
    private List<Long> categories;

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