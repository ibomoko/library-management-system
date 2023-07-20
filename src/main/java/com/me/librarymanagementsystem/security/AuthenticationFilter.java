package com.me.librarymanagementsystem.security;

import com.me.librarymanagementsystem.constant.SecurityConstants;
import com.me.librarymanagementsystem.error.exception.AuthorizationException;
import com.me.librarymanagementsystem.model.UserClaims;
import com.me.librarymanagementsystem.model.UserCredentials;
import com.me.librarymanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter extends OncePerRequestFilter {
    private final AuthService authService;
    private final JWTProvider jwtProvider;
    private final SecurityConstants securityConstants;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (StringUtils.startsWith(authorizationHeader, "Bearer ")) {
            String token = authorizationHeader.substring(7);
            if (StringUtils.isNotBlank(token)) {
                //Checking username and password
                UserClaims userClaims = jwtProvider.validateToken(token);
                UserCredentials userCredentials = authService.checkUserExisting(userClaims.getEmail(), userClaims.getRole());
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(
                                userCredentials.getEmail(),
                                userCredentials.getPassword(),
                                List.of(new SimpleGrantedAuthority(userClaims.getRole().name()))
                        );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                throw new AuthorizationException("Invalid authorization header");
            }

        }

        doFilter(request, response, filterChain);
    }

}
