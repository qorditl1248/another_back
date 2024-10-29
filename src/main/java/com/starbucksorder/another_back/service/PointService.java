package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.response.point.RespUserDto;
import com.starbucksorder.another_back.entity.User;
import com.starbucksorder.another_back.exception.UserNotFoundException;
import com.starbucksorder.another_back.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {
    @Autowired

    private UserMapper userMapper;

    // HACK: 전화번호로 포인트와 사용자 id 가져오기
    public RespUserDto getUserIdByPhoneNumber(String phoneNumber) {
        RespUserDto user = null;
        try {
            user = findUserByPhoneNumber(phoneNumber).toRespUserDto();
            if (user == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new UserNotFoundException("사용자를 찾을 수 없습니다");
        }
        return user;
    }

    private User findUserByPhoneNumber(String phoneNumber) {
        User user = userMapper.findUserByPhoneNumber(phoneNumber);
        return user;
    }

}
