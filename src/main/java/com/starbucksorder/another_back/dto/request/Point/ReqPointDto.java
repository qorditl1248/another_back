package com.starbucksorder.another_back.dto.request.Point;

import lombok.Data;

import java.util.Date;

@Data
public class ReqPointDto {

    private String phoneNumber;
    private Long cartId;
    private int point;
    private String memo;

}
