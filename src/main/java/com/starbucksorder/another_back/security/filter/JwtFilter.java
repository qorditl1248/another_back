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
import java.util.List;

@Component
public class JwtFilter extends GenericFilter {
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String requestURI = httpServletRequest.getRequestURI().toString();
        List<String> permitAllUrls = List.of(
                "/menu",
                "/user",
                "/category",
                "/home",
                "/error"
        );
        if (permitAllUrls.contains(requestURI.substring(0, requestURI.indexOf("/", 1) != -1 ? requestURI.indexOf("/", 1) : requestURI.length()))) {
            chain.doFilter(request, response);
            return;
        }

        String bearerToken = httpServletRequest.getHeader("Authorization");

        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }
        String token = jwtProvider.removeBearerToken(bearerToken);
        Claims payLoad = null;
        try {
            payLoad = jwtProvider.parseToken(token);
            Long adminId = ((Integer) payLoad.get("adminId")).longValue();
            Admin admin = adminMapper.findById(adminId);
            if (admin == null) {
                throw new JwtException("user Not Found");
            }
            PrincipalUser principalUser = admin.toPrincipal();
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException e) {
            e.printStackTrace();
            chain.doFilter(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
}
