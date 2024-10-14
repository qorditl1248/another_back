package com.starbucksorder.another_back.dto.request.Point;

import lombok.Data;

@Data
public class ReqUsePointDto {

    private String phoneNumber;
    private int point;
    private Long pointType;
}
