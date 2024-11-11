package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.ReqAdminSalePageDateDto;
import com.starbucksorder.another_back.dto.admin.response.CMRespAdminDto;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespAdminDashBoard;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespAdminSaleListDto;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespSaleDto;
import com.starbucksorder.another_back.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

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
        return new CMRespAdminDto(orderMapper.totalSaleCount(dto.toLocalDateTime()),respSaleDtos);
    }

    public Object getDetail(String date) {
        return null;
    }
}