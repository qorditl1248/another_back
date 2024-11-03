package com.starbucksorder.another_back.dto.admin.request.order;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
public class ReqAdminOrderDto {
    private Long page;
    private Long limit;
    private String startDate;
    private String endDate;

    public Map<String, Object> toLocalDateTime() {
        Long startIndex = (page - 1) * limit;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDateTime trStartDate;
        LocalDateTime trEndDate;
        if (startDate == null || startDate.isEmpty()) {
            trStartDate = LocalDateTime.now().minusDays(7);
            trEndDate = LocalDateTime.now();
        } else {
            trStartDate = LocalDateTime.parse(startDate, formatter);
            trEndDate = LocalDateTime.parse(endDate, formatter);
        }
        return Map.of("startDate", trStartDate, "endDate", trEndDate, "startIndex", startIndex, "limit", limit);
    }
}
