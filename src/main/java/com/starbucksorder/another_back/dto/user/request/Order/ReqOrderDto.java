package com.starbucksorder.another_back.dto.user.request.Order;

import com.starbucksorder.another_back.entity.Coupon;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.OrderDetail;
import com.starbucksorder.another_back.entity.User;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ReqOrderDto {
    //uuid
    private String paymentId;
    // 전체 총 금액
    private int totalAmount;
    // takeout : 1, eat-in : 2
    private Long orderType;
    private customer customer;
    // 상품들
    private List<Product> products;

    @Data
    public static class customer {
        private Long userId;
        private String phoneNumber;
        private List<coupon> coupons;

        public User toUser() {
            return User.builder()
                    .phoneNumber(phoneNumber)
                    .build();
        }

    }

    @Data
    public static class coupon {
        private Long couponId;
        private String couponName;
        private LocalDateTime registerDate;

        public Coupon toEntity() {
            return Coupon.builder()
                    .couponId(couponId)
                    .couponName(couponName)
                    .registerDate(registerDate)
                    .build();
        }
    }

    @Data
    public static class Product {
        private Long id; // menuId
        private String name; // 상세
        private int amount; // 상품 개별 옵션포함한 금액합계
        private int quantity; // 총 수량

        public OrderDetail toOrderDetailEntity() {
            return OrderDetail.builder()
                    .menuId(id)
                    .quantity(quantity)
                    .orderComment(name)
                    .build();
        }
    }

    public Order toOrderEntity() {
        List<OrderDetail> orderDetails = products.stream().map(Product::toOrderDetailEntity).collect(Collectors.toList());
        return Order.builder()
                .userId(customer.getUserId())
                .paymentId(paymentId)
                .orderType(orderType)
                .orderAmount(totalAmount)
                .orderDetails(orderDetails)
                .build();
    }


}