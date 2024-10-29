package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.OrderDetail;
import com.starbucksorder.another_back.entity.User;
import com.starbucksorder.another_back.repository.OrderDetailMapper;
import com.starbucksorder.another_back.repository.OrderMapper;
import com.starbucksorder.another_back.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private UserMapper userMapper;

    // 주문목록 저장
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveOrder(ReqOrderDto dto) {
        Order order = dto.toOrderEntity();
        // 번호조회 먼저
        User user = findUser(dto.getCustomer().getPhoneNumber());
        if (user == null) {
            user = dto.getCustomer().toUser();
            // 번호등록
            userMapper.saveUser(user);
        }
        order.setUserId(user.getUserId());
        // 주문등록
        orderMapper.save(order);
        // 주문 상세 등록
        orderDetailMapper.save(order.getOrderDetails(), order.getOrderId());

    }

    public User findUser(String phoneNumber) {
        User user = userMapper.findUserByPhoneNumber(phoneNumber);
        return user;
    }
}