package com.starbucksorder.another_back.dto.admin.request.option;

import lombok.Data;

import java.util.List;
@Data
public class ReqAdminOptionsDto {
    private List<Long> optionIds;
    private Long optionId;
}