package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    int saveCartType(Cart cart);
    Long getCartId(Long cartId);
}
