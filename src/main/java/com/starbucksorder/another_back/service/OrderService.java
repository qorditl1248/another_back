package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.order.ReqAdminOrderDto;
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
    public boolean saveOrder(ReqOrderDto dto) {
        // 적립요청이 아닌 것 == 번호자체가 없음
        if (dto.getCustomer().getPhoneNumber().length() == 4) {
            save(dto, null);
            // 요청 데이터에 번호가 있는데 회원이 없는 경우 등록해주고 id 받아야함
        } else {
            User user = findUser(dto.getCustomer().getPhoneNumber());
            if (user == null) {
                // 번호등록
                user = user.builder().phoneNumber(dto.getCustomer().getPhoneNumber()).build();
                userMapper.saveUser(user);
            }
            save(dto, user.getUserId());
            // 적립
            System.out.println(user);
            user.setStarCount(dto.getTotalQuantity());
            userMapper.updateStar(user);
            //userId, totalQuantity
        }
        return true;
    }

    public void findByDate(ReqAdminOrderDto dto) {
        System.out.println(dto.toLocalDateTime());
//        orderMapper.findByDate(dto.toLocalDateTime());
    }

    private User findUser(String phoneNumber) {
        User user = userMapper.findUserByPhoneNumber(phoneNumber);
        return user == null ? null : user;
    }


    // 저장
    private void save(ReqOrderDto dto, Long userId) {
        System.out.println(dto);
        System.out.println(userId);
        Order order = dto.toOrderEntity(userId);
        System.out.println(order);
        orderMapper.save(order);
        // 주문 상세 등록
        orderDetailMapper.save(order.getOrderDetails(), order.getOrderId());
    }


}