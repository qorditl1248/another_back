package com.starbucksorder.another_back.dto.user.request.Point;

import lombok.Data;

@Data
public class ReqPointDto {
    private Long userId;
    private int total; //총금액
}
