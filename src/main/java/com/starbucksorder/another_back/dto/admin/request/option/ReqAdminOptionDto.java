package com.starbucksorder.another_back.dto.admin.request.option;

import com.starbucksorder.another_back.entity.Option;
import com.starbucksorder.another_back.entity.OptionDetail;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ReqAdminOptionDto {
    private Long optionId;
    private String optionName;
    private Long optionStatus;
    private HashMap<String, Integer> optionDetail;

    public Option toEntity() {
        return Option.builder()
                .optionId(optionId)
                .optionName(optionName)
                .optionStatus(optionStatus)
                .build();
    }

    public OptionDetail toDetailEntity(Long optionId,String value, int price) {
        return OptionDetail.builder()
                .optionId(optionId)
                .optionDetailValue(value)
                .optionDetailPrice(price)
                .build();
    }

}
