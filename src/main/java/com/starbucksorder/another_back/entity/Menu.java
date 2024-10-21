package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starbucksorder.another_back.dto.admin.MenuDto;
import com.starbucksorder.another_back.dto.user.response.menu.RespMenuListAll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private String comment;
    private Long menuStatus;
    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    private String imgUrl;

    private List<MenuDetail> menuDetails; // menu : menudetail = 1 : many

    private String categories;
    private String options;

    public RespMenuListAll toMenuList() {
        return RespMenuListAll.builder()
                .menuId(menuId)
                .menuName(new String(menuName.getBytes(StandardCharsets.UTF_8)))
                .build();
    }

    // 관리자 메뉴페이지
    public MenuDto.RespMenuList toPageMenuList() {
        return MenuDto.RespMenuList.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .categories(categories)
                .options(options)
                .build();
    }

}
