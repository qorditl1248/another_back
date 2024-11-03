package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    int save(Order order);

    int updateStatus(Order order);

    Long findOrderIdByUserId(Long userId);

    List<Order> findByDate(Map<String, Object> map);

    int countByDate(Map<String, Object> map);

    Order findOrderById(Long orderId);
}
