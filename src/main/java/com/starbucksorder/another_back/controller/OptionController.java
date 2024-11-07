package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.admin.request.option.ReqAdminOptionDto;
import com.starbucksorder.another_back.service.MenuService;
import com.starbucksorder.another_back.service.OptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private OptionService optionService;
    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "옵션 추가 요청")
    @PostMapping("/admin/option")
    public ResponseEntity<?> add(@RequestBody ReqAdminOptionDto dto) {
        return ResponseEntity.ok().body(optionService.add(dto));
    }

    // FIXME: 페이징처리 안함 -> 검토 필요
    @ApiOperation(value = "옵션 전체조회")
    @GetMapping("/admin/option")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(optionService.getAll());
    }

    @ApiOperation(value = "옵션id에 해당하는 옵션 상세보기 조회요청")
    @GetMapping("/admin/option/{optionId}")
    public ResponseEntity<?> getById(@PathVariable Long optionId) {
        return ResponseEntity.ok().body(optionService.getById(optionId));
    }

    @ApiOperation(value = "옵션id에 해당하는 메뉴들 조회요청")
    @GetMapping("/admin/option/menus")
    public ResponseEntity<?> getById(@RequestParam List<Long> ids) {
        return ResponseEntity.ok().body(optionService.getAllByOptionIds(ids));
    }

    @ApiOperation(value = "옵션id에 해당하는 삭제요청 -> 프로시저호출로 연쇄삭제")
    @DeleteMapping("/admin/option/{optionId}")
    public ResponseEntity<?> delete(@PathVariable Long optionId) {
        return ResponseEntity.ok().body(optionService.delete(optionId));
    }

    @ApiOperation(value = "옵션id에 해당하는 수정요청")
    @PatchMapping("/admin/option/{optionId}")
    public ResponseEntity<?> update(@PathVariable Long optionId, @RequestBody ReqAdminOptionDto dto) {
        return ResponseEntity.ok().body(optionService.update(dto));
    }

    @ApiOperation(value = "옵션id에 해당하는 활성/비활성화 상태 수정 요청")
    @PatchMapping("/admin/option/status/{optionId}")
    public ResponseEntity<?> updateStatus(@PathVariable Long optionId) {
        return ResponseEntity.ok().body(optionService.updateStatus(optionId));
    }
}
