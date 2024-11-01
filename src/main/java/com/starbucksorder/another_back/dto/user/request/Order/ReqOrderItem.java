package com.starbucksorder.another_back.dto.user.request.Order;

import lombok.Data;

import java.util.List;

@Data
public class ReqOrderItem {
    private List<Long> items;
}
