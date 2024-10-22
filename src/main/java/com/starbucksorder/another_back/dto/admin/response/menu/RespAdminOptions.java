package com.starbucksorder.another_back.dto.admin.response.menu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAdminOptions {
    private Long optionId;
    private String optionName;
}