package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    private Long couponId;
    private Long userId;
    private String couponName;
    private LocalDateTime registerDate;
    private LocalDateTime useDate;

}
