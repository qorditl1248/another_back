package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starbucksorder.another_back.dto.admin.response.menu.MenuAdminDetailRespDto;
import com.starbucksorder.another_back.dto.admin.response.menu.RespAdminMenuList;
import com.starbucksorder.another_back.dto.user.response.menu.RespOnlyMenuIdAdnName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    // 메뉴 아이디, 이름만 뿌려주는 메소드
    public RespOnlyMenuIdAdnName toRespOnlyIdAndNameDto() {
        return RespOnlyMenuIdAdnName.builder()
                .menuId(menuId)
                .menuName(menuName)
                .build();
    }

    // 관리자 메뉴페이지
    public RespAdminMenuList toPageMenuList() {
        return RespAdminMenuList.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .menuStatus(menuStatus)
                .categories(categories)
                .options(options)
                .build();
    }

    // 관리자 메뉴 상세보기 리턴
    public MenuAdminDetailRespDto toMenuDetail() {
        return MenuAdminDetailRespDto.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .comment(comment)
                .menuStatus(menuStatus)
                .imgUrl(imgUrl)
                .options(options)
                .categories(categories)
                .build();
    }



}
