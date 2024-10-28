package com.starbucksorder.another_back.dto.user.response.point;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class RespCouponDto {
    private Long couponId;
    private Long userId;
    private int starCount;
    private LocalDateTime registerDate;

    private String couponName;
}
