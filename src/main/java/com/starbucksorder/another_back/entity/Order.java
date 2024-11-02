package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long orderType;
    private Integer orderAmount; // 전체 주문 금액
    private Integer totalQuantity;
    private Long orderState; // 결제 완료 or 취소
    private Date createDate;
    private List<OrderDetail> orderDetails;
    // FIXME: 결제유형 추가 됨 1 : 카드 2 : 복합결제(쿠폰 사용)
    private Integer paymentType;

}
