package com.starbucksorder.another_back.dto.admin.request.menu;
import lombok.Data;

@Data
public class ReqAdminMenuDto {
    private Long page;
    private Long limit;
    private String searchName;
}