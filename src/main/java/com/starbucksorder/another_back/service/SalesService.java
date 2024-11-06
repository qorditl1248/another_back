package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.order.ReqAdminOrderDto;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespAdminDashBoard;
import com.starbucksorder.another_back.dto.admin.response.Sales.RespSaleDto;
import com.starbucksorder.another_back.entity.Order;
import com.starbucksorder.another_back.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {
    @Autowired
    private OrderMapper orderMapper;

    public RespAdminDashBoard getStatistics() {

        // 셀로 표시 될 대시보드
        RespSaleDto resp = orderMapper.findByDateForSale();

        // 월별 매출
        List<RespAdminDashBoard.RespMonthly> monthly = orderMapper.monthlyRevenue();

        // 최다 판매 도넛 그래프
        List<RespAdminDashBoard.RespMostMenu> mostMenus = orderMapper.mostMenus();

        return new RespAdminDashBoard(resp, monthly, mostMenus);
    }

    // 매출관리
    public List<RespSaleDto> getSales(ReqAdminOrderDto dto) {
        List<RespSaleDto> respSaleDtos = orderMapper.getSale(dto.toLocalDateTime());
        return respSaleDtos;
    }
}
