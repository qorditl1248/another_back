package com.starbucksorder.another_back.dto.admin.response.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RespAdminDto {
    private Long userId;
    private String phoneNumber;
    private String memo;
    private int starCount;
    private LocalDateTime registerDate;
}
