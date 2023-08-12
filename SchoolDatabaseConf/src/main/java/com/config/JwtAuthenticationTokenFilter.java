package com.config;

import com.config.exception.InvalidAuthenticationException;
import com.config.security.AuthenticatedUser;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        String authToken = request.getHeader("Authorization");

//        if (request.getRequestURI().endsWith(request.getContextPath() + "/")) {
//            chain.doFilter(request, response);
//            return;
//        }
//        if (authToken != null && !authToken.isEmpty()) {
//            if (!authToken.startsWith("Bearer ")) {
//                throw new InvalidAuthenticationException();
//            }
//            Claims claims = jwtHelper.verifyAndDecodeJwt(authToken);
//            if (claims == null) {
//                throw new InvalidAuthenticationException();
//            }
//
//            String userType = claims.get("userType", String.class);
//            String userCode = claims.get("userCode", String.class);
//            String branch = claims.get("branch", String.class);
//            String id = claims.get("id", String.class);
//            String branchCode = claims.get("branchCode", String.class);
//            String fiscalYear = claims.get("fiscalYear", String.class);
//            AuthenticatedUser authenticatedUser = new AuthenticatedUser(id, userCode, branch, userType, branchCode, fiscalYear);
//            // For simple validation it is completely sufficient to just check the token integrity. You don't have to call
////            // the database compellingly. Again it's up to you ;)
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authenticatedUser, null, new ArrayList<>());
////             log.info("----- Authenticated User: " + userCode + "-" + uri + " " + method);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        }
        chain.doFilter(request, response);

    }

}
