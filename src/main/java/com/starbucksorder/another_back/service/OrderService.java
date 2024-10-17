package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.dto.user.request.Point.ReqPointDto;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.OrderDetail;
import com.starbucksorder.another_back.repository.OrderDetailMapper;
import com.starbucksorder.another_back.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    // 주문목록 저장
    public Long saveOrder(ReqOrderDto dto){
        Order order = dto.toOrderEntity();
        orderMapper.save(order);

//        OrderDetail orderDetail = dto.toOrderDetailEntity(order.getOrderId());
//        orderDetailMapper.save(orderDetail);

        Long orderId = order.getOrderId();
        orderDetailMapper.save(dto.toOrderDetailEntity(orderId));

        return orderId;
    }
}
