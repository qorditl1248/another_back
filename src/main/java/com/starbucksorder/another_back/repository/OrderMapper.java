package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int save(Order order);
    int update(Long orderId);
    Long findOrderIdByUserId(Long userId);
}
