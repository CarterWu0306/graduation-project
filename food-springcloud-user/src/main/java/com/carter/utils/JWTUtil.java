package com.carter.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JWTUtil {
    public static final String SECRET_KEY = "123456"; //秘钥
    public static final int TOKEN_EXPIRE_TIME = 30 * 60 * 1000; //token过期时间(毫秒)   30分钟
    public static final int REFRESH_TOKEN_EXPIRE_TIME = 60 * 60 * 1000; //refreshToken过期时间(毫秒)
    private static final String ISSUER = "issuer"; //签发人

    /**
     * 生成签名
     */
    public static String generateToken(String username){
        Date now = new Date();
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); //算法

        String token = JWT.create()
                .withIssuer(ISSUER) //签发人
                .withIssuedAt(now) //签发时间
                .withExpiresAt(new Date(now.getTime() + TOKEN_EXPIRE_TIME)) //过期时间
                .withClaim("username", username) //保存身份标识
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token,合法性,是否过期,是否被篡改
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); //算法
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 从token获取username
     */
    public static String getUsername(String token){
        try{
            return JWT.decode(token).getClaim("username").asString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}
