package com.starbucksorder.another_back.dto.admin.response.order;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class RespOrderDetailDto {
    private Long orderId;
    private Long userId;
    private String paymentId;
    private Integer paymentType;
    private Long orderType;
    private Integer orderAmount; // 전체 주문 금액
    private Long orderState; // 결제 완료 or 취소
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<RespOrderDetail> orderDetail;

    @Builder
    @Data
    public static class RespOrderDetail {
        private Long orderDetailId;
        private Long menuId;
        private int quantity;
        private String orderComment;

    }
}
