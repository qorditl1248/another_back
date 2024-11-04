package com.starbucksorder.another_back.dto.admin.response.Sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespSaleDto {
    private Long totalAmount;
    private Long orderCount;
    private Long refundAmount;
    private Long refundCount;
    private Long todayTotalAmount;
    private Long todayOrderCount;
    private Long todayRefundAmount;
    private Long todayRefundCount;
}
