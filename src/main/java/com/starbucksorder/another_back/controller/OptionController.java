package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.admin.request.option.ReqAdminOptionDto;
import com.starbucksorder.another_back.dto.admin.request.option.ReqAdminOptionsDto;
import com.starbucksorder.another_back.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private OptionService optionService;

    // 옵션 추가
    @PostMapping("/admin/option")
    public ResponseEntity<?> add(@RequestBody ReqAdminOptionDto dto) {
        optionService.add(dto);
        return ResponseEntity.ok().body(dto);
    }

    // 옵션 전체 조회
    @GetMapping("/admin/option")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(optionService.getAll());
    }

    // 옵션에 속한 메뉴들 전체 불러오기
    @Log
    @GetMapping("/admin/option/menus")
//    public ResponseEntity<?> getById(@RequestParam ReqAdminOptionsDto dto) {
    public ResponseEntity<?> getById(@RequestParam List<Long> ids) {
//        return ResponseEntity.ok().body(optionService.getAllByOptionIds(dto));
        return ResponseEntity.ok().body(optionService.getAllByOptionIds(ids));
    }

    //옵션 삭제
    @DeleteMapping("/admin/option/{optionId}")
    public ResponseEntity<?> delete(@PathVariable Long optionId) {
        return ResponseEntity.ok().body(optionService.delete(optionId));
    }

    @PatchMapping("/admin/option/{optionId}")
    public ResponseEntity<?> updateStatus(@PathVariable Long optionId) {
        return ResponseEntity.ok().body(optionService.updateStatus(optionId));
    }
}
