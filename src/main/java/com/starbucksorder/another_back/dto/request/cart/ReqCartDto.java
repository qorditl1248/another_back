package com.starbucksorder.another_back.dto.request.cart;

import com.starbucksorder.another_back.entity.Cart;
import lombok.Data;

@Data
public class ReqCartDto {
    private Long orderType;

    public Cart toEntity() {
        return Cart.builder()
                .orderType(orderType)
                .build();
    }
}