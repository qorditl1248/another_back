package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Point {
    private Long pointId;
    private Long userId;
    private int point;
}
