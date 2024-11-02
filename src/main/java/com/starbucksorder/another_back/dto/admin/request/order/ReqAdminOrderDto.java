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
        LocalDateTime trStartDateTime = LocalDateTime.parse(startDate, formatter);
        LocalDateTime trEndDateTime = LocalDateTime.parse(endDate, formatter);
        System.out.println(trStartDateTime);
        return Map.of("startDate", trStartDateTime, "endDate", trEndDateTime);
    }
}
