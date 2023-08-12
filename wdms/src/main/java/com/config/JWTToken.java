package com.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Calendar;
import java.util.Date;

public class JWTToken {

    private static String signWith = "/SchoolPayment/src/main/java/com/config/JWTToken.java";
    private static String bioDeviceToken = "bioDeviceTokenOfSchool";
    private String userId, userName, userType;
    private boolean status;

    public JWTToken() {
    }

    public static String get(String userId, String userName, String userType) {
        String token = "";
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            token = Jwts.builder().
                    setId(userId)
                    .setIssuer(userName)
                    .setAudience(userType)
                    .claim("roles", "user")
                    .setIssuedAt(date)
                    .setExpiration(c.getTime())
                    .signWith(SignatureAlgorithm.HS256, signWith).compact();
        } catch (Exception e) {
        }
        return token;

    }

    

    public JWTToken(String Authorization) {
        status = false;
        String token = Authorization.substring(7);
        try {
            final Claims claims = Jwts.parser().setSigningKey(signWith).parseClaimsJws(token).getBody();
            status = true;
            userId = claims.getId();
            userName = claims.getIssuer();
            userType = claims.getAudience();

        } catch (final SignatureException e) {
            userId = "";
            userName = "";
            userType = "";
            status = false;
        }
    }
public void deviceTokenDecode(String Authorization) {
        status = false;
        String token = Authorization.substring(7);
        try {
            final Claims claims = Jwts.parser().setSigningKey(bioDeviceToken).parseClaimsJws(token).getBody();
            status = true;
            userId = claims.getId();
            userName = claims.getIssuer();          
        } catch (final SignatureException e) {
            userId = "";
            userName = "";
            userType = "";
            status = false;
        }
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "{\"userId\":\"" + userId + "\",\"userType\":\"" + userType + "\",\"userName\":\"" + userName + "\"}";
    }
}
