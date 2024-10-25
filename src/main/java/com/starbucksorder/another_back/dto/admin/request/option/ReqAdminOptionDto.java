package com.starbucksorder.another_back.dto.admin.request.option;

import com.starbucksorder.another_back.entity.Option;
import lombok.Data;

@Data
public class ReqAdminOptionDto {
    private Long optionId;
    private String optionName;

    public Option toEntity(){
        return Option.builder()
                .optionId(optionId)
                .optionName(optionName)
                .build();
    }

}
