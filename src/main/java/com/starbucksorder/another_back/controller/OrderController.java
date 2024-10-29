package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 주문목록 저장 ( 적립 안하는 사람은 userId = null )
    // HACK: 포트원 도입 전 데이터 요청 확인
    // HACK: ReqOrderPortOneDto -> ReqOrderDto 변경
    @Log
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ReqOrderDto order){
        orderService.saveOrder(order);
        return ResponseEntity.ok().body(order);
    }


}
