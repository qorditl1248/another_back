package com.starbucksorder.another_back.dto.admin.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
public class ReqAdminPageDateDto {
    private Long page;
    private Long limit;
    private String startDate;
    private String endDate;

    public Map<String, Object> toLocalDateTime() {
        Long startIndex = (page - 1) * limit;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate trStartDate = null;
        LocalDate trEndDate = null;

        int dateType = 0;

        if (startDate == null || startDate.isEmpty()) {
            trStartDate = LocalDate.now().minusDays(7);
            trEndDate = LocalDate.now();
        }
        else if (startDate.length() == 7) {
            trStartDate = LocalDate.parse(startDate, monthFormatter);
            trEndDate = LocalDate.parse(endDate, monthFormatter);
            dateType = 1;
        }
        else if (startDate.length() > 7) {
            trStartDate = LocalDate.parse(startDate, formatter);
            trEndDate = LocalDate.parse(endDate, formatter);
        }
        return Map.of("startDate", trStartDate, "endDate", trEndDate, "startIndex", startIndex, "limit", limit, "dateType", dateType);
    }

}
