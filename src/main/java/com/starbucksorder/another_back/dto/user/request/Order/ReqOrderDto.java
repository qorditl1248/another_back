package com.starbucksorder.another_back.dto.user.request.Order;

import com.starbucksorder.another_back.entity.Coupon;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.OrderDetail;
import com.starbucksorder.another_back.entity.User;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Data
public class ReqOrderDto {
    private String paymentId;
    private int totalAmount; // 전체 총 금액
    // takeout : 1, eatin : 2
    private Long orderType;
    private User customer;

    // couponId
    private List<ReqOrderDto.Product> products;

    @Data
    public static class Product {
        private Long id; // menuId
        private String name; // 상세
        private int amount; // 상품 개별 옵션포함한 금액합계
        private int quantity; // 총 수량
//        private int couponId;

        public OrderDetail toOrderDetailEntity(Long orderId) {
            return OrderDetail.builder()
                    .orderId(orderId)
                    .menuId(id)
                    .quantity(quantity)
                    .orderComment(name)
                    .build();
        }
    }

    public Order toOrderEntity() {
        return Order.builder()
                .userId(customer.getUserId())
                .paymentId(paymentId)
                .orderType(orderType)
                .orderAmount(totalAmount)
                .build();
    }


}