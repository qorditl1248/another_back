package com.starbucksorder.another_back.dto.admin.response.Sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespAdminDashBoard {
    private RespSaleDto respSaleDto;
    private List<RespMonthly> monthly;
    private List<RespMostMenu> mostMenus;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RespMonthly {
        private int month;
        private int totalSales;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RespMostMenu {
        private Long menuId;
        private String menuName;
        private int rank;
    }
}
