package com.starbucksorder.another_back.entity;

import com.starbucksorder.another_back.dto.admin.response.order.RespOrderListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private Long orderId;
    private Long userId;
    private String paymentId;
    private Integer paymentType;
    private Long orderType;
    private Integer orderAmount; // 전체 주문 금액
    private Integer totalQuantity;
    private Long orderState; // 결제 완료 or 취소
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<OrderDetail> orderDetails;
    // FIXME: 결제유형 추가 됨 1 : 카드 2 : 복합결제(쿠폰 사용)

    public RespOrderListDto toRespOrderListDto() {
        return RespOrderListDto.builder()
                .orderId(orderId)
                .paymentId(paymentId)
                .paymentType(paymentType)
                .orderType(orderType)
                .orderAmount(orderAmount)
                .orderState(orderState)
                .createDate(createDate)
                .build();
    }



}
