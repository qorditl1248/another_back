package com.starbucksorder.another_back.entity;

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
    private Long status;
    private Date createDate;
    private Date updateDate;
    private String imgUrl;

    private List<MenuDetail> menuDetails; // menu : menudetail = 1 : many

}
