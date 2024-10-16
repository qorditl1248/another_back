package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.admin.request.ReqSigninDto;
import com.starbucksorder.another_back.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    // 로그인
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody ReqSigninDto dto){
        authService.signin(dto);
        return ResponseEntity.ok().body("success");
    }
}
