package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.request.Point.ReqPointDto;
import com.starbucksorder.another_back.dto.request.Point.ReqUsePointDto;
import com.starbucksorder.another_back.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PointController {

    @Autowired
    private PointService pointService;

    // 포인트 적립
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
