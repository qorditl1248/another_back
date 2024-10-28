package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long userId;
    private String phoneNumber;
    private String memo;
    private int starCount;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

    private List<Coupon> coupon;

}
