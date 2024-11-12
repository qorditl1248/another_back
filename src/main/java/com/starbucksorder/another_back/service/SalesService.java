package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.ReqAdminSalePageDateDto;
import com.starbucksorder.another_back.dto.admin.response.CMRespAdminDto;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespAdminDashBoard;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespAdminSaleAndMenusDto;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespAdminSaleListDto;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespSaleDto;
import com.starbucksorder.another_back.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalesService {
    @Autowired
    private OrderMapper orderMapper;

    public RespAdminDashBoard getStatistics(String selectYear) {
        Year currentYear = null;
        if (selectYear == null || selectYear.isBlank() || selectYear.equals("undefined")) {
            currentYear = Year.now();
        } else {
            currentYear = Year.parse(selectYear);
        }
        System.out.println(currentYear);
        // 있는 연도 표시
        List<Integer> yearCount = orderMapper.getYearCount();

        // 셀로 표시 될 대시보드
        RespSaleDto resp = orderMapper.findByDateForSale(currentYear);

        // 월별 매출
        List<RespAdminDashBoard.RespMonthly> monthly = orderMapper.monthlyRevenue(currentYear);

        // 최다 판매 도넛 그래프
        List<RespAdminDashBoard.RespMostMenu> mostMenus = orderMapper.mostMenus(currentYear);

        return new RespAdminDashBoard(yearCount, resp, monthly, mostMenus);
    }

    // 매출관리
    public CMRespAdminDto getSales(ReqAdminSalePageDateDto dto) {
        List<RespAdminSaleListDto> respSaleDtos = orderMapper.getSale(dto.toLocalDateTime());
        return new CMRespAdminDto(orderMapper.totalSaleCount(dto.toLocalDateTime()), respSaleDtos);
    }

    public RespAdminSaleAndMenusDto getDetail(String date) {
        // 날짜 형식이 2024-10 /  2024-10-24
        LocalDate criteriaDate;

        int dateType = 0;
        YearMonth yearMonth = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        // 월로 변환 -> 만일 변환이 안 된다면
        if (date.length() == 7) {
            yearMonth = YearMonth.parse(date, formatter);
            criteriaDate = yearMonth.atDay(1);
            dateType = 0;
        } else {
            // 일별
            criteriaDate = LocalDate.parse(date);
            dateType = 1;
        }
        List<RespAdminSaleAndMenusDto.wtf> sale = orderMapper.getByDate(Map.of("criteriaDate", criteriaDate, "dateType", dateType));
        List<RespAdminSaleAndMenusDto.Menus> menus = orderMapper.getMostMenus(Map.of("criteriaDate", criteriaDate, "dateType", dateType));
        Map<String, Long> map;
        if (sale != null) {
//            map = sale.stream().collect(Collectors.toMap(RespAdminSaleAndMenusDto.wtf::getType, RespAdminSaleAndMenusDto.wtf::getTotalAmount));
            map = sale.stream()
                    .collect(Collectors.toMap(
                            item -> item.getType(),
                            item -> item.getTotalAmount() != null ? item.getTotalAmount() : 0L // null일 경우 기본 값 설정
                    ));

            return RespAdminSaleAndMenusDto.builder()
                    .totalAmount(map.getOrDefault("totalAmount", 0L))
                    .cardTotalAmount(map.getOrDefault("cardTotalAmount", 0L))
                    .complexTotalAmount(map.getOrDefault("complexTotalAmount", 0L))
                    .refundTotalAmount(map.getOrDefault("refundTotalAmount", 0L))
                    .menus(menus)
                    .build();
        }
        return null;
    }
}