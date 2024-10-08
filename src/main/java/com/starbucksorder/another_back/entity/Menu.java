package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Menu {
    private Long menuId;
    private Long categoryId;
    private String menuName;
    private String menuPrice;
    private String comment;
    private Long status;
    private Date createDate;
    private Date updateDate;
    private String imgUrl;

    private Set<MenuDetail> menuDetails; // menu : menudetail = 1 : many
}
