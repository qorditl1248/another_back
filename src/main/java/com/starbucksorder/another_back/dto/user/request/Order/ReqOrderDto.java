package com.starbucksorder.another_back.dto.user.request.Order;

import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.OrderDetail;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

@Data
public class ReqOrderDto {
    private Long userId;
    private Long paymentId;
    private Long orderType; // 먹고갈게요 가져갈게요
    private int orderAmount; // 총 주문 갯수


    private Long menuId;
    private int quantity; // 메뉴별 갯수
    private String orderComment; // 메뉴별 옵션, 갯수, 이름 등...



    public Order toOrderEntity() {
        return Order.builder()
                .userId(userId)
                .paymentId(paymentId)
                .orderType(orderType)
                .orderAmount(orderAmount)
                .build();
    }

    public OrderDetail toOrderDetailEntity(Long orderId) {
        return OrderDetail.builder()
                .orderId(orderId)
                .menuId(menuId)
                .quantity(quantity)
                .orderComment(orderComment)
                .build();
    }
}