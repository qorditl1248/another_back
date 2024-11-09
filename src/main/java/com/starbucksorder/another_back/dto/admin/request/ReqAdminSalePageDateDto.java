package com.starbucksorder.another_back.dto.admin.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Data
public class ReqAdminSalePageDateDto {
    private Long page;
    private Long limit;
    // 월 단위 / 일 단위
    private String dateMode;
    private String startDate;
    private String endDate;


    public Map<String, Object> toLocalDateTime() {
        Long startIndex = (page - 1) * limit;

        DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        LocalDate trStartDate = null;
        LocalDate trEndDate = null;

        // 월 단위(month), 일 단위(day)

        // 0번이 일별, 1 : 월별, 2:연별
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
            /*trStartDate = LocalDate.parse(refineStartDate, monthFormatter);
            trEndDate = LocalDate.parse(refineEndDate, monthFormatter);*/

            YearMonth startMonth = YearMonth.parse(refineStartDate, monthFormatter);
            YearMonth endMonth = YearMonth.parse(refineEndDate, monthFormatter);
            trStartDate = startMonth.atDay(1); // 월의 첫째 날로 설정
            trEndDate = endMonth.atEndOfMonth(); // 월의 마지막 날로 설정
            dateType = 1;
            // 날짜가 월,일 까지 있는 경우 일별 조회로 간주
        } else if (refineEndDate.length() > 7) {
            trStartDate = LocalDate.parse(refineStartDate, dayFormatter);
            trEndDate = LocalDate.parse(refineEndDate, dayFormatter);
            dateType = 0;

            // 날짜가 연별로 간주
        } else {
            trStartDate = LocalDate.parse(refineStartDate, yearFormatter);
            trEndDate = LocalDate.parse(refineEndDate, yearFormatter);
            dateType = 2;
        }
        return Map.of(
                "startDate", trStartDate,
                "endDate", trEndDate,
                "startIndex", startIndex,
                "limit", limit,
                "dateType", dateType,
                "dateMode", dateMode.equals("day") ? 0 : 1);
    }
}
