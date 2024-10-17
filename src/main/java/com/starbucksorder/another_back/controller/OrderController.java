package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 주문목록 저장 ( 적립 안하는 사람은 userId = null )
    @PostMapping("/cart")
    public ResponseEntity<?> saveOrderType(@RequestBody ReqOrderDto dto) {
        orderService.saveOrder(dto);
        return ResponseEntity.ok().body(true);
    }
}
