package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestMenuList {
    private Long menuId;
    private Long categoryId;
//    private String categoryName;
    private String menuName;
    private String menuPrice;
    private String comment;
    private Long status;
    private String createDate;
    private String updateDate;
    private String url;

    private Set<TestCategory> testCategory;


/*
TestMenuList:{
    menuId: "",
    categoryId: "",
    categoryName: "",
    menuName: "",
    menuPrice: "",
    comment: "",
    status: "",
    createDate: "",
    updateDate: "",
    url: "",
    testCategory :{
        categoryId : "",
        categoryName : "",
        status : "",
        createDate : "",
        updateDate : ""
        }
    }
*/

}
