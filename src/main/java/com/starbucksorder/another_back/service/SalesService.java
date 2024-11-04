package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.response.Sales.RespSaleDto;
import com.starbucksorder.another_back.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesService {
    @Autowired
    private OrderMapper orderMapper;

    public RespSaleDto getStatistics() {
        RespSaleDto resp = orderMapper.findByDateForSale();
        System.out.println(resp);
        return resp;
    }

    public void getSales() {
//        orderMapper.
        }
}
