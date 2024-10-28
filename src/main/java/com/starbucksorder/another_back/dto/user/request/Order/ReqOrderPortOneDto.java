package com.starbucksorder.another_back.dto.user.request.Order;

import lombok.Data;

import java.util.List;

@Data
public class ReqOrderPortOneDto {
    private String merchantId;
    private int amount;
    // takeout : 1, eatin : 2
    private Long orderType;
    private List<orderDetail> products;

    @Data
    public static class orderDetail {
        private Long id;
        private String name;
        private int amount;
        private int quantity;
//        private List<optionsDto> options;
    }
//    @Data
//    public static class optionsDto {
//        private Long optionId;
//        private String optionName;
//        private String optionDetailValue;
//    }
}
