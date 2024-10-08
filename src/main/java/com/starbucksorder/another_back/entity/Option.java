package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Option {
    private Long optionId;
    private String optionName;
    private Date createDate;
    private Date updateDate;

    private Set<OptionDetail> optionDetail; // optionDetail : option = many : 1
}
