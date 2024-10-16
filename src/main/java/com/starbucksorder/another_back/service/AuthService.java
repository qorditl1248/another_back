package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.ReqSigninDto;
import com.starbucksorder.another_back.entity.Admin;
import com.starbucksorder.another_back.exception.BadCredentialException;
import com.starbucksorder.another_back.repository.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        System.out.println(dto);
        // 아이디확인 Optional
        Admin admin = adminMapper.findByUserName(dto.getUsername()).orElseThrow(
                // 없어도 되긴해서 얘만 생성하지 않아 봄 (Advice만 생성)
                () -> new UsernameNotFoundException("Username not found")
        );
        System.out.println(admin);
        // 비밀번호 확인
        if (!bCryptPasswordEncoder.matches(dto.getPassword(), admin.getPassword())) {
            throw new BadCredentialException("Bad credentials");
        }
        // 토큰 생성

    }
}
