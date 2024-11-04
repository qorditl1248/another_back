package com.starbucksorder.another_back.dto.admin.request.order;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
public class ReqAdminOrderDto {
    private Long page;
    private Long limit;
    private String startDate;
    private String endDate;

    // FIXME: type 도입 전 로직 나중에 삭제 될 예정
    /*
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
     */

    public Map<String, Object> toLocalDateTime() {
        Long startIndex = (page - 1) * limit;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate trStartDate = null;
        LocalDate trEndDate = null;

        int dateType = 0;
        // 공백(시간)을 기준으로 날짜만 추출하는 로직
        String refineStartDate = (startDate != null) ? startDate.split(" ")[0] : null;
        String refineEndDate = (endDate != null) ? endDate.split(" ")[0] : null;

        // 날짜가 없는 경우 최근 7일 조회
        if (startDate == null || startDate.isEmpty()) {
            trStartDate = LocalDate.now().minusDays(7);
            trEndDate = LocalDate.now();

            // 날짜가 있지만 월 까지 있는 경우 월별 조회로 간주
        } else if (refineStartDate.length() == 7) {
            trStartDate = LocalDate.parse(refineStartDate, monthFormatter);
            trEndDate = LocalDate.parse(refineEndDate, monthFormatter);

            // 날짜가 월,일 까지 있는 경우 일별 조회로 간주
        } else {
            trStartDate = LocalDate.parse(refineStartDate, formatter);
            trEndDate = LocalDate.parse(refineEndDate, formatter);

            dateType = 2;
        }
        return Map.of(
                "startDate", trStartDate,
                "endDate", trEndDate,
                "startIndex", startIndex,
                "limit", limit,
                "dateType", dateType);
    }
}
