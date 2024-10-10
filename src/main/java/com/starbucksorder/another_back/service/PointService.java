package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.request.Point.ReqPointDto;
import com.starbucksorder.another_back.entity.User;
import com.starbucksorder.another_back.repository.PointMapper;
import com.starbucksorder.another_back.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private UserMapper userMapper;

    // 포인트 적립
    public void addPoints(ReqPointDto dto) {
        User user = userMapper.findUserByPhoneNumber(dto.getPhoneNumber());
        System.out.println(user);

        if(user != null) {
            pointMapper.save(user.getUserId(), dto.getPoint());
            return;
        } else {
            userMapper.saveUser(dto);
            user = userMapper.findUserByPhoneNumber(dto.getPhoneNumber());
            pointMapper.save(user.getUserId(), dto.getPoint());
        }
    }


}
