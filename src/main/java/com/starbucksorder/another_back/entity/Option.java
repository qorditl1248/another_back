package com.starbucksorder.another_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starbucksorder.another_back.dto.admin.response.menu.RespAdminOptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Option {
    private Long optionId;
    private String optionName;
    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;


    private List<OptionDetail> optionDetail; // optionDetail : option = many : 1

    public RespAdminOptions toOptionsDto(){
        return RespAdminOptions.builder()
                .optionId(optionId)
                .optionName(optionName)
                .build();
    }
}
