package com.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Calendar;
import java.util.Date;

public class JWTToken {

    private static String signWith = "/SchoolPayment/src/main/java/com/config/JWTToken.java";
    private String smsToken = "SchoolSMSToken#infowebnep@gmail.com";
    private String thirdPartysmsToken = "ThirdPartyToken#infowebnep@gmail.com";
    private String paymentToken = "SchoolPaymentToken";
    private String userId, userName, branch;
    private boolean status;

    public JWTToken() {
    }

    public boolean paymentTokenDecode(String Authorization) {
        status = false;
        String token = Authorization.substring(7);
        try {
            final Claims claims = Jwts.parser().setSigningKey(paymentToken).parseClaimsJws(token).getBody();
            status = true;
            userId = claims.getId();
            userName = claims.getIssuer();
            branch = claims.getAudience();

        } catch (final SignatureException e) {
            userId = "";
            userName = "";
            branch = "";
            status = false;

        }
        return status;
    }

    public String getPaymentToken(String userId, String userName, String userType) {
        String token = "";
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, (5 * 365));
            token = Jwts.builder().
                    setId(userId)
                    .setIssuer(userName)
                    .setAudience(userType)
                    .claim("roles", "user")
                    .setIssuedAt(date)
                    .setExpiration(c.getTime())
                    .signWith(SignatureAlgorithm.HS256, paymentToken).compact();
        } catch (Exception e) {
        }
        return token;

    }

    public boolean smsToken(String Authorization) {
        status = false;
        String token = Authorization.substring(7);
        try {
            final Claims claims = Jwts.parser().setSigningKey(smsToken).parseClaimsJws(token).getBody();
            status = true;
            userId = claims.getId();
            userName = claims.getIssuer();

        } catch (final SignatureException e) {
            userId = "";
            userName = "";
            status = false;

        }
        return status;
    }

    public String thirdPartysmsToken(String userId, String userName) {
        String token = "";
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, (5 * 365));
            token = Jwts.builder().
                    setId(userId)
                    .setIssuer(userName)
                    .setAudience(branch)
                    .claim("roles", "user")
                    .setIssuedAt(date)
                    .setExpiration(c.getTime())
                    .signWith(SignatureAlgorithm.HS256, thirdPartysmsToken).compact();
        } catch (Exception e) {
        }
        return token;
    }

    public boolean thirdPartysmsToken(String Authorization) {
        status = false;
        String token = Authorization.substring(7);
        try {
            final Claims claims = Jwts.parser().setSigningKey(thirdPartysmsToken).parseClaimsJws(token).getBody();
            status = true;
            userId = claims.getId();
            userName = claims.getIssuer();

        } catch (final SignatureException e) {
            userId = "";
            userName = "";
            status = false;

        }
        return status;
    }

    public static String get(String userId, String userName, String branch) {
        String token = "";
        try {
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            token = Jwts.builder().
                    setId(userId)
                    .setIssuer(userName)
                    .setAudience(branch)
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
            branch = claims.getAudience();

        } catch (final SignatureException e) {
            userId = "";
            userName = "";
            branch = "";
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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    

    @Override
    public String toString() {
        return "{\"userId\":\"" + userId + "\",\"branch\":\"" + branch + "\",\"userName\":\"" + userName + "\"}";
    }
}
