package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.admin.request.option.ReqAdminOptionDto;
import com.starbucksorder.another_back.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //옵션 삭제
    @DeleteMapping("/admin/option/{optionId}")
    public ResponseEntity<?> delete(@PathVariable Long optionId) {
        return ResponseEntity.ok().body(optionService.delete(optionId));
    }
}
