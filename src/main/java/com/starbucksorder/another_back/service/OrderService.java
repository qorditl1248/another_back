package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.User;
import com.starbucksorder.another_back.repository.OrderDetailMapper;
import com.starbucksorder.another_back.repository.OrderMapper;
import com.starbucksorder.another_back.repository.UserMapper;
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
    private UserMapper userMapper;

    // 주문목록 저장
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveOrder(ReqOrderDto dto) {
        // 번호가 없다면 적립요청이 아닌 것
        if (dto.getCustomer().getPhoneNumber().length() == 4) {
            Order order = dto.toOrderEntity(null);
            orderMapper.save(order);
            orderDetailMapper.save(order.getOrderDetails(), order.getOrderId());
        } else {

            User user = findUser(dto.getCustomer().getPhoneNumber());
            // 번호조회 먼저
            if (user == null) {
                // 사용자가 없다면 저장
                user = dto.getCustomer().toUser();
                // 번호등록
                userMapper.saveUser(user);
                // 진행 후 아이디 담기
                user.setUserId(user.getUserId());
            }
            Order order = dto.toOrderEntity(user.getUserId());
            // 주문등록
            orderMapper.save(order);
            // 주문 상세 등록
            orderDetailMapper.save(order.getOrderDetails(), order.getOrderId());
            // 적립
            user = User.builder()
                    .userId(order.getUserId())
                    .starCount(order.getTotalQuantity())
                    .build();

            userMapper.updateStar(user.builder()
                    .userId(order.getUserId())
                    .starCount(order.getTotalQuantity())
                    .build());
        }
        System.out.println("성공");
    }

    public User findUser(String phoneNumber) {
        User user = userMapper.findUserByPhoneNumber(phoneNumber);
        return user;
    }

}