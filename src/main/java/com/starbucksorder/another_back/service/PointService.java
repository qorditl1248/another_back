package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.user.request.Point.ReqPointDto;
import com.starbucksorder.another_back.dto.user.request.Point.ReqUsePointDto;
import com.starbucksorder.another_back.dto.user.request.User.ReqUserDto;
import com.starbucksorder.another_back.dto.user.response.point.RespPointDto;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.entity.Point;
import com.starbucksorder.another_back.entity.User;
//import com.starbucksorder.another_back.exception.UserNotFoundException;
import com.starbucksorder.another_back.exception.UserNotFoundException;
import com.starbucksorder.another_back.repository.OrderMapper;
import com.starbucksorder.another_back.repository.PointMapper;
import com.starbucksorder.another_back.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
public class PointService {

    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private UserMapper userMapper;

    // 포인트 적립 전, 사용 전 userId 찾기
    public Long getUserId(ReqUserDto dto) {
        User user = userMapper.findUserByPhoneNumber(dto.getPhoneNumber());

        if(user != null) {
            return user.getUserId();
        } else {
            userMapper.saveUser(dto.getPhoneNumber());
        }
        return user.getUserId();
    }

    // 포인트 적립
    public void addPoint(ReqPointDto dto) {

        if(dto.getUserId() != null) {
            int point = (int) (dto.getTotal() * 0.1);
            pointMapper.save(dto.getUserId(), point);
        }
    }


    // 포인트조회
    public RespPointDto getPoints(Long userId) {
        Point point = pointMapper.getPoints(userId);

        return RespPointDto.builder()
                .userId(point.getUserId())
                .totalPoints(point.getPoint() / 4000)
                .build();
    }

    // 포인트 사용
    public void usePoints(ReqUsePointDto dto) {

        User user = userMapper.findUserByUserId(dto.getUserId());

        if (user != null) {
            int userPoint = (pointMapper.getPoints(user.getUserId()).getPoint()) / 4000;
            System.out.println(userPoint);

            if (userPoint >= dto.getPoint()) {
                pointMapper.usePoints(user.getUserId(), (dto.getPoint() * 4000));
                return;
            } else {
                throw new RuntimeException("포인트가 부족합니다.");
            }
        }
//        else {
//            throw new UserNotFoundException("가입된 사용자가 없습니다.");
//            // throw new UsernameNotFoundException("가입된 사용자가 없습니다."); 나중에 security 주석 풀고 이거 써주나..???
//        }
    }
}
