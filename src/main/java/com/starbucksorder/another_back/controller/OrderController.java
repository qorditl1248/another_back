package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderDto;
import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderItem;
import com.starbucksorder.another_back.service.MenuService;
import com.starbucksorder.another_back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private MenuService menuService;


    // 주문목록 저장 ( 적립 안하는 사람은 phoneNumber = "010-" )
    @Log
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ReqOrderDto order){
        return ResponseEntity.ok().body(orderService.saveOrder(order));
    }
    @Log
    @GetMapping("/product/items")
    public ResponseEntity<?> getProductItem(ReqOrderItem dto) {
        return ResponseEntity.ok().body(menuService.findByIds(dto));
    }

    // NOTE: 어드민


}
