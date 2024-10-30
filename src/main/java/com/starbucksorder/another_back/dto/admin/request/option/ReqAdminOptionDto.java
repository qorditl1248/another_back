package com.starbucksorder.another_back.dto.admin.request.option;

import com.starbucksorder.another_back.entity.Option;
import lombok.Data;

import java.util.Map;

@Data
public class ReqAdminOptionDto {
    private Long optionId;
    private String optionName;
    private Long optionStatus;
    private Map<String, Integer> values;

    public Option toEntity() {
        return Option.builder()
                .optionId(optionId)
                .optionName(optionName)
                .optionStatus(optionStatus)
                .build();
    }

}
