package com.starbucksorder.another_back.dto.user.response.cart;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RespCartDto {
    private Long cartId;
}

