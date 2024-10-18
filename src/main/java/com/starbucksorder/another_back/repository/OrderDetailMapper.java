package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
    int save(OrderDetail orderDetail);
}

