package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long userId;
    private String phoneNumber;
    private String memo;
    private Date RegisterDate;
    private Date UpdateDate;
}
