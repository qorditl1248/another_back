package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.request.cart.ReqCartDto;
import com.starbucksorder.another_back.entity.Cart;
import com.starbucksorder.another_back.repository.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartMapper cartMapper;

    // 먹고갈게요 포장할게요
    public Long saveOrderType(ReqCartDto dto){
        Cart cart = dto.toEntity();
        cartMapper.saveCartType(cart);

        Long cartId = cartMapper.getCartId(cart.getCartId());

        return cartId;


    }
}
