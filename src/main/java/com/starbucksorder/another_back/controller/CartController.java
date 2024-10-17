package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.user.request.cart.ReqCartDto;
import com.starbucksorder.another_back.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    // 먹고갈게요 포장할게요
    @PostMapping("/cart")
    public ResponseEntity<?> saveOrderType(@RequestBody ReqCartDto dto) {
        return ResponseEntity.ok().body(cartService.saveOrderType(dto));
    }
}
