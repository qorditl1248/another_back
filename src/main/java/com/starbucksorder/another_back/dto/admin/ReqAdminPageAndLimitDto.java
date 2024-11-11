package com.starbucksorder.another_back.dto.admin;

import lombok.Data;

@Data
public class ReqAdminPageAndLimitDto {
    private Long page;
    private Long limit;
}
