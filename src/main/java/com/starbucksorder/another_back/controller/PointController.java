package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.user.request.Point.ReqPointDto;
import com.starbucksorder.another_back.dto.user.request.Point.ReqUsePointDto;
import com.starbucksorder.another_back.dto.user.request.User.ReqUserDto;
import com.starbucksorder.another_back.repository.OrderMapper;
import com.starbucksorder.another_back.service.OrderService;
import com.starbucksorder.another_back.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PointController {

    @Autowired
    private PointService pointService;
    @Autowired
    private OrderService orderService;

    // 포인트 적립 할래요 : 포인트 적립 전 userid 확인
    @GetMapping("/points/user")
    public ResponseEntity<?> getUser(@RequestBody ReqUserDto dto) {
        return ResponseEntity.ok().body(pointService.getUserId(dto));
    }

    // 포인트 적립 할래요 : 결제 성공 후 -> 포인트 적립 및 order_tb 결제 완료 상태로 변경
    // 포인트 적립 안할래요 : 결제 성공 후 -> order_tb 결제 완료 상태로 변경
    @PostMapping("/points")
    public ResponseEntity<?> addPoints(@RequestBody ReqPointDto dto) {
        pointService.addPoints(dto);

        return ResponseEntity.ok().body(true);
    }


    // 포인트 조회
    @GetMapping("/points/{userId}")
    public ResponseEntity<?> getPoints(@PathVariable Long userId) {
        return ResponseEntity.ok().body(pointService.getPoints(userId));
    }

    // 포인트 사용
    @PostMapping("/points/{userId}")
    public ResponseEntity<?> usePoints(@RequestBody ReqUsePointDto dto) {
        pointService.usePoints(dto);
        return ResponseEntity.ok().body(true);
    }
}
