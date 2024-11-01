package com.starbucksorder.another_back.dto.admin.request.user;

import lombok.Data;

import java.util.List;

@Data
public class ReqAdminDeleteDto {
    private List<Long> userIds;
}
