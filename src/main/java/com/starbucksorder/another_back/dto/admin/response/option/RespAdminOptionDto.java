package com.starbucksorder.another_back.dto.admin.response.option;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespAdminOptionDto {
    private Long optionId;
    private String optionName;
    private List<RespOptionDetail> optionDetail; // optionDetail : option = many : 1

    @Builder
    @Data
    public static class RespOptionDetail {
        private Long optionDetailId;
        private String optionDetailValue;
        private int optionDetailPrice;
    }
}
