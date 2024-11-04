package com.starbucksorder.another_back.dto.admin.response.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespOrderListDto {
    private Long orderId;
    //        private Long userId;
    private String paymentId;
    private Integer paymentType;
    private Long orderType;
    private Integer orderAmount; // 전체 주문 금액
    //        private Integer totalQuantity;
    private Long orderState; // 결제 완료 or 취소
    private LocalDateTime createDate;
//        private LocalDateTime updateDate;
}