package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long adminId;
    private String username;
    private String password;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
}
