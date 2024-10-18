package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    private String imgUrl;

    private List<MenuDetail> menuDetails; // menu : menudetail = 1 : many

}
