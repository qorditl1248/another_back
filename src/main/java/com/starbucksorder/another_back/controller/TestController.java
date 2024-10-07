package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.request.ReqTestDto;
import com.starbucksorder.another_back.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public ResponseEntity<?> testPost(@RequestBody ReqTestDto dto) {
        log.info("요청 받음 : {}", dto);

        testService.save(dto);
        return ResponseEntity.ok().body(true);
    }
}
