package com.starbucksorder.another_back.dto.request;

import com.starbucksorder.another_back.entity.Test;
import lombok.Data;

@Data
public class ReqTestDto {

    private Long categoryId;
    private String categoryName;
    private Long status;
    private String createDate;
    private String updateDate;

    public Test toEntity() {
        return Test.builder()
                .categoryId(categoryId)
                .categoryName(categoryName)
                .status(status)
                .createDate(createDate)
                .updateDate(updateDate)
                .build();
    }

}
