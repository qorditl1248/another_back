package com.starbucksorder.another_back.dto.admin.request.order;

import lombok.Data;

import java.time.LocalDate;
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
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate trStartDate;
        LocalDate trEndDate;
        if (startDate == null || startDate.isEmpty()) {
            trStartDate = LocalDate.now().minusDays(7);
            trEndDate = LocalDate.now();
        } else {
            trStartDate = LocalDate.parse(startDate, formatter);
            trEndDate = LocalDate.parse(endDate, formatter);
        }
        return Map.of("startDate", trStartDate, "endDate", trEndDate, "startIndex", startIndex, "limit", limit);
    }
}
