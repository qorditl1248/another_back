package com.starbucksorder.another_back.security.filter;

import com.starbucksorder.another_back.entity.Admin;
import com.starbucksorder.another_back.repository.AdminMapper;
import com.starbucksorder.another_back.security.jwt.JwtProvider;
import com.starbucksorder.another_back.security.principal.PrincipalUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class JwtFilter extends GenericFilter {
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AdminMapper adminMapper;

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String bearerToken = httpServletRequest.getHeader("Authorization");
        System.out.println("bearerToken: " + bearerToken);
        if (bearerToken == null) {
            chain.doFilter(request, response);
            return;
        }
        String token = jwtProvider.removeBearerToken(bearerToken);
        Claims payLoad = jwtProvider.parseToken(token);

        Long adminId = ((Integer) payLoad.get("adminId")).longValue();

        Admin admin = adminMapper.findById(adminId);
        if (admin == null) {
            throw new JwtException("user Not Found");
        }

        PrincipalUser principalUser = admin.toPrincipal();
        Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser,null,principalUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 예외처리 구현
        chain.doFilter(request, response);
    }
}
