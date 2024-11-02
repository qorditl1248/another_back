package com.starbucksorder.another_back.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {
    // 쿠폰사용
    int updateUseDateById(List<Long> ids);
}
