package com.starbucksorder.another_back.dto.user.request.Order;

import lombok.Data;

import java.util.List;

@Data
public class ReqOrderPortOneDto {
    private Long merchantId;
    private int amount;
    private Long orderType;
    private String totalQuantity;
    private List<orderDetail> productList;

    public static class orderDetail {
        private Long menuId;
        private String menuName;
        private int quantity;
        private List<optionsDto> options;
    }

    public static class optionsDto {
        private Long optionId;
        private String optionName;
        private String valueName;
    }
}
