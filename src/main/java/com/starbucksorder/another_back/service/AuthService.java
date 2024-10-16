package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.ReqSigninDto;
import com.starbucksorder.another_back.entity.Admin;
import com.starbucksorder.another_back.repository.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    // 로그인
    public void signin(ReqSigninDto dto) {
        Admin admin = adminMapper.findByUserName(dto.getUsername());
        // 아이디확인
        if (admin != null) {
            // 비밀번호 확인
            if (bCryptPasswordEncoder.matches(dto.getPassword(), admin.getPassword())) {
                // 토큰 생성
                System.out.println(true);
            // 일치하지않음
            } else {
                System.out.println(false);
            }
        }
        // 아이디가 없는 경우
        System.out.println("아이디를 찾을 수 없음");
    }
}
