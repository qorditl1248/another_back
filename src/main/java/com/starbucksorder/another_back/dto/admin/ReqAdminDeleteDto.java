package com.starbucksorder.another_back.dto.admin;

import lombok.Data;

import java.util.List;

@Data
public class ReqAdminDeleteDto {
    private List<Long> ids;
}