package com.starbucksorder.another_back.dto.admin.response.Sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespAdminSaleAndMenusDto {


    private Long totalAmount;
    private Long cardTotalAmount;
    private Long complexTotalAmount;
    private Long refundTotalAmount;
    private List<Menus> menus;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Menus {
        private String menuName;
        private Long totalQuantity;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class wtf {
        private String type;
        private Long totalAmount;
    }
}
