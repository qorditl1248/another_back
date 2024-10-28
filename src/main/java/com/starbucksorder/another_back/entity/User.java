package com.starbucksorder.another_back.entity;

import com.starbucksorder.another_back.dto.user.response.point.RespUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<Coupon> coupons;

    public RespUserDto toRespUserDto() {
        return RespUserDto.builder()
                .userId(userId)
                .phoneNumber(phoneNumber)
                .starCount(starCount)
                .isSuccess(true)
                .Coupons(coupons.stream().map(Coupon::toCouponDto).collect(Collectors.toList()))
                .build();
    }

}
