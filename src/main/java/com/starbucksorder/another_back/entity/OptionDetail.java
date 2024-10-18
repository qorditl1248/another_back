package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionDetail {
    private Long optionDetailId;
    @JsonIgnore
    private Long optionId;
    private String optionDetailValue;
    private String optionDetailPrice;
}
