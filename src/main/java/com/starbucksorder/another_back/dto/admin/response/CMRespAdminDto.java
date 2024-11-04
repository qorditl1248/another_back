package com.starbucksorder.another_back.dto.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CMRespAdminDto<T> {
    private int totalCount;
    private T data;
}