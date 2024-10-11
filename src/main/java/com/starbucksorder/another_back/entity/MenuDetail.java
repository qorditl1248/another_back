package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDetail {
    private Long menuDetailId;
    private Long menuId;
    private Long optionId;

    private List<Option> options; // option : menudetail = many : 1
}
