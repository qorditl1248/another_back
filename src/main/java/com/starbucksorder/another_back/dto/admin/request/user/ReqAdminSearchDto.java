package com.starbucksorder.another_back.dto.admin.request.user;

import lombok.Data;

@Data
public class ReqAdminSearchDto {
    private Long page;
    private Long limit;
    private String searchName;
}
