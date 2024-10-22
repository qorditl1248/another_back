package com.starbucksorder.another_back.dto.admin.response.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CMRespAdminDto<T> {
    private int totalCount;
    private T data;
}