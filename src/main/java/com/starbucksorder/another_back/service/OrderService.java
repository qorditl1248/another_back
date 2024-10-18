package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.repository.OrderDetailMapper;
import com.starbucksorder.another_back.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private PointService pointService;

    // 주문목록 저장
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveOrder(ReqOrderDto dto){
        Order order = dto.toOrderEntity();
        orderMapper.save(order);

        orderDetailMapper.save(dto.toOrderDetailEntity(order.getOrderId()));
        // 포트원 ? 결제성공 ?
    }
}
