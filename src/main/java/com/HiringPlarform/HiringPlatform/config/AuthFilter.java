package com.HiringPlarform.HiringPlatform.config;

import com.google.api.Http;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Exchanger;

@Service
@Slf4j
public class AuthFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            Enumeration<String> headerNames = httpRequest.getHeaderNames();


            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                List<String> headerValues = Collections.list(httpRequest.getHeaders(headerName));

                System.out.println(headerName + ": " + String.join(", ", headerValues));
            }
        }
        System.out.println(request.getAuthType());
        System.out.println(request.getContextPath());
        System.out.println(Arrays.toString(request.getCookies()));
        System.out.println(request.getHttpServletMapping());
        log.info(request.getRemoteAddr());
        log.info(request.getHeader("X-Forwarded-For"));
        log.info(request.getHeader("User-Agent"));
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            List<GrantedAuthority> role = null;
            String username = null;
            log.info(request.getRemoteAddr());
            log.info(request.getHeader("User-Agent"));
//            try {
//                username = jwtService.extractUsername(token);
//                role = jwtService.extractRoles(token);
//            } catch (Exception e) {
//                response.setStatus(400);
//            }
            Cookie cookie = new Cookie("tempCookie", "123");
            log.info(cookie.toString());
            cookie.setAttribute("token", authHeader);
            response.addCookie(cookie);
            response.setStatus(201);
            log.info("======================>" + request.getRemoteHost());

            if (role != null && username != null) {
                Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                        username,
                        token,
                        role
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }



            filterChain.doFilter(request, response);
        }

        filterChain.doFilter(request, response);

    }
}
