package com.starbucksorder.another_back.dto.admin.response.Sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespAdminSaleListDto {
    private int totalCount;
    private String date;
    private int totalAmount;
    private int totalOrderCount;
    private int refundAmount;
    private int totalRefundCount;
}