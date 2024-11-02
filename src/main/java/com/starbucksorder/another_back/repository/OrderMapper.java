package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.Map;

@Mapper
public interface OrderMapper {
    int save(Order order);

    int update(Long orderId);

    Long findOrderIdByUserId(Long userId);

    Order findByDate(Map<String, LocalDateTime> map);
}
