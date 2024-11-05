package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.service.SalesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;


    // NOTE: 매출 관련 컨트롤러
    @ApiOperation(value = "매출관리에서 사용 되는 getAll")
    @GetMapping()
    public ResponseEntity<?> getSales() {
        salesService.getSales();
        return ResponseEntity.ok().body(null);
    }

    @ApiOperation(value = "관리자페이지 접속시 나올 대시보드")
    @Log
    @GetMapping("/manage/dashboard")
    public ResponseEntity<?> getStatistics() {
        return ResponseEntity.ok().body(salesService.getStatistics());
    }

}
