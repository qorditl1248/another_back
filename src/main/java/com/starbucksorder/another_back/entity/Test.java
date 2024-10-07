package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test {
    private Long categoryId;
    private String categoryName;
    private Long status;
    private String createDate;
    private String updateDate;
}
