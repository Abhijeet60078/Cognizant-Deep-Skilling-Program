package com.cognizant.springlearn.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthorizationFilter
        extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String header=request.getHeader("Authorization");

        if(header!=null && header.startsWith("Bearer ")){

            String token=header.replace("Bearer ","");

            try{

                Jws<Claims> claims=

                        Jwts.parser()
                                .setSigningKey("secretkey")
                                .parseClaimsJws(token);

                String user=claims.getBody().getSubject();

                UsernamePasswordAuthenticationToken authentication=

                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                Collections.emptyList());

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);

            }
            catch(Exception e){

                response.setStatus(
                        HttpServletResponse.SC_UNAUTHORIZED);

                return;
            }

        }

        filterChain.doFilter(request,response);

    }

}