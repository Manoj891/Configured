package com.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class JwtHelper {

    private final String privateKey = "nepal@PaymentSolutions#DigihubBrokerOfficeSolutionsPvt.Ltd";

    public String createToken(String id, String userName, String branch, String userType, String branchCode, String fiscalYear) {
        String token = "";
        try {
            Date issueDate = new Date();
            String expiresDate = new SimpleDateFormat("yyyy-MM-dd").format(issueDate) + " 23:59:59";
            Date expiresAt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(expiresDate);

            try {
                token = Jwts.builder().
                        setId(id)
                        .claim("userType", userType)
                        .claim("userCode", userName)
                        .claim("branch", branch)
                        .claim("branchCode", branchCode)
                        .claim("id", id)
                        .claim("fiscalYear", fiscalYear)
                        .setIssuedAt(issueDate)
                        .setExpiration(expiresAt)
                        .signWith(SignatureAlgorithm.HS256, privateKey).compact();
            } catch (Exception e) {
            }
//        System.out.println(token);
        } catch (Exception e) {
            token = e.getMessage();
        }
        return token;

    }

    public Claims verifyAndDecodeJwt(String Authorization) {

        if (Authorization.startsWith("Bearer ")) {
            try {
                return Jwts.parser().setSigningKey(privateKey).parseClaimsJws(Authorization.substring(7)).getBody();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
