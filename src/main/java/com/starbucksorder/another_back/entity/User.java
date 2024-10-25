package com.starbucksorder.another_back.entity;

import com.starbucksorder.another_back.dto.user.response.point.RespPointDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long userId;
    private String phoneNumber;
    private String memo;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private Point point;
}
