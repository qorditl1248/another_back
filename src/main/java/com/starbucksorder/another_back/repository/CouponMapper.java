package com.starbucksorder.another_back.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponMapper {
    // 쿠폰사용
    int updateUseDateById(Long couponId);
}
