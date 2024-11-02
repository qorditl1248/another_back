package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.service.MenuService;
import com.starbucksorder.another_back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 주문목록 저장 ( 적립 안하는 사람은 phoneNumber = "010-" )
    @Log
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ReqOrderDto order) {
        return ResponseEntity.ok().body(orderService.saveOrder(order));
    }
    // FIXME: @GetMapping("/product/items") MenuController 로 이동됨

    // NOTE: 관리자 주문관리


}
