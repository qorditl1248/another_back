package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.request.Point.ReqPointDto;
import com.starbucksorder.another_back.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
