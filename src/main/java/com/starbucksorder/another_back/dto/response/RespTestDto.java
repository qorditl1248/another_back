package com.starbucksorder.another_back.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespTestDto {
    private Long categoryId;
    private String categoryName;
    private Long status;
    private String createDate;
    private String updateDate;
}
