package com.starbucksorder.another_back.dto.admin.request;

import com.starbucksorder.another_back.entity.User;
import lombok.Data;

@Data
public class ReqAdminUserDto {
    private String phoneNumber;
    private String memo;
    private int starCount;

    public User toEntity() {
        return User.builder()
                .phoneNumber(phoneNumber)
                .memo(memo)
                .starCount(starCount)
                .build();
    }
}
