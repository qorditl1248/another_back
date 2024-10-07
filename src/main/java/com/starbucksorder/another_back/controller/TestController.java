package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.request.ReqTestDto;
import com.starbucksorder.another_back.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    // 등록
    @PostMapping("/test")
    public ResponseEntity<?> testPost(@RequestBody ReqTestDto dto) {
        log.info("요청 받음 : {}", dto);

        testService.save(dto);
        return ResponseEntity.ok().body(true);
    }

    // 단건 조회
    @GetMapping("/test/{categoryId}")
    public ResponseEntity<?> testGet(@PathVariable Long categoryId) {
        log.info("id: {}", categoryId);
        return ResponseEntity.ok().body(testService.get(categoryId));
    }

//    // 다건 조회
//    @GetMapping("/test/list")
//    public ResponseEntity<?> getTests() {
//        return ResponseEntity.ok().body(testService.getAll());
//    }


    // 삭제
    @DeleteMapping("/test/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable Long categoryId) {
        log.info("id: {}", categoryId);

        testService.delete(categoryId);
        return ResponseEntity.ok().body(true);
    }

    // 수정
    @PutMapping("/test/{categoryId}")
    public ResponseEntity<?> update(@RequestBody ReqTestDto dto) {

        testService.update(dto);
        return ResponseEntity.ok().body(true);
    }


    // 카테고리별 메뉴리스트
    @GetMapping("/menus")
    public ResponseEntity<?> getMenusByCategory() {
        System.out.println("menus");
        return ResponseEntity.ok().body(testService.getMenus());
    }



}
