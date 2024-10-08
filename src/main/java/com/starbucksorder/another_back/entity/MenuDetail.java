package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDetail {
    private Long menuDetailId;
    private Long menuId;
    private Long optionId;

    private Set<Option> options; // option : menudetail = many : 1
}
