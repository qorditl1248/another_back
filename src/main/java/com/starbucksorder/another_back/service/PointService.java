package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.response.point.RespCouponDto;
import com.starbucksorder.another_back.entity.User;
import com.starbucksorder.another_back.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private UserMapper userMapper;

    // HACK: 전화번호로 포인트와 사용자 id 가져오기
    public User getUserIdByPhoneNumber(String phoneNumber) {
        User user = userMapper.findUserByPhoneNumber(phoneNumber);
        //userId, couponId, couponName registerDate,
        return user;
    }

}
