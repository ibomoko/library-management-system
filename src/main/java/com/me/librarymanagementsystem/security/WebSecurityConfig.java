package com.me.librarymanagementsystem.security;


import com.me.librarymanagementsystem.constant.SecurityConstants;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    @SneakyThrows
    public SecurityFilterChain filterChain(HttpSecurity http,  SecurityConstants securityConstants) {
        http.csrf().disable().cors().and()
                .authorizeRequests()
                .antMatchers(securityConstants.getWhitelist()).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }


}
