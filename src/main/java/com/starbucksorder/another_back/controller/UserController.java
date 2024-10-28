package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.user.request.Point.ReqPointDto;
import com.starbucksorder.another_back.dto.user.request.Point.ReqUsePointDto;
import com.starbucksorder.another_back.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// HACK: 매핑명 변경 /points -> point
@RequestMapping("/point")
public class UserController {

    @Autowired
    private PointService pointService;

    // 포인트 적립 할래요 : 포인트 적립 전 userId 확인
    // 포인트 사용 : 포인트 사용 전 userId 확인
    // HACK: 응답 데이터 확인
    @Log
    @GetMapping("/user/phone")
    public ResponseEntity<?> getUserId(@RequestParam String phoneNumber) {
        return ResponseEntity.ok().body(pointService.getUserIdByPhoneNumber(phoneNumber));
    }

    // 포인트 적립 할래요 : 결제 성공 후 -> 포인트 적립
    // 포인트 적립 안할래요 : 결제 성공 -> 끝


    // 포인트 사용

    // 포인트 조회


}
