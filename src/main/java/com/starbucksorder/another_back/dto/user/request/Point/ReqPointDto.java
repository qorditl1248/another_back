package com.starbucksorder.another_back.dto.user.request.Point;

import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.Point;
import lombok.Data;

import java.util.Date;

@Data
public class ReqPointDto {
    private Long userId;
    private int total; //총금액
}
