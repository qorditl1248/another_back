package com.starbucksorder.another_back.dto.admin.request.order;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
public class ReqAdminOrderDto {
    private String startDate;
    private String endDate;

    public Map<String, LocalDateTime> toLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDateTime trStartDate;
        LocalDateTime trEndDate;

        if (startDate == null || startDate.isEmpty()) {
            trStartDate = LocalDateTime.now().minusDays(7);
            trEndDate = LocalDateTime.now();
        }
//        if (startDate.)
        else {
            trStartDate = LocalDateTime.parse(startDate, formatter);
            trEndDate = LocalDateTime.parse(endDate, formatter);
        }
        System.out.println(trStartDate);
        System.out.println(trEndDate);
        System.out.println(trStartDate);
        return Map.of("startDate", trStartDate, "endDate", trEndDate);
    }
}
