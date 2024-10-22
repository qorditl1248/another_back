package com.starbucksorder.another_back.config;

import com.starbucksorder.another_back.security.filter.JwtFilter;
import com.starbucksorder.another_back.security.handler.AuthenticationHandler;
import com.starbucksorder.another_back.security.handler.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private AuthenticationHandler AuthenticationHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().formLogin().and().csrf().disable();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/auth/signin").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated().and().exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
//                .antMatchers("/auth/signin","/home/**","/category/**","/menu/**").permitAll()
        // 토큰 'Authentication' 객체 만들어주지 못하였을 때 발생 할 handler
        http.exceptionHandling().authenticationEntryPoint(AuthenticationHandler);

        // jwtFilter
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
