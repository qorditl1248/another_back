package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail {

    private Long cartItemId;
    private Long orderId;
    private Long menuId;
    private int quantity;
    private String orderComment;
}
