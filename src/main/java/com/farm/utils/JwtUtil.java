package com.farm.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;


/**
 * @name: JwtUtil
 * @description: JwtUtil
 */
@Slf4j
public class JwtUtil {

    /**
     * 由字符串生成加密key
     *
     * @param args 参数
     * @throws Exception 异常
     */
    public static void main (String[] args) throws Exception {
        Claims claims = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwZDQ1ZGJkMWJjNmE0M2M4YjlmYzg0ODY4MGZmNjEyYiIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY4MjU4MTk2OCwiZXhwIjoxNjgyNTg1NTY4fQ.onlhC3wQVPy0g4htCMDkarbubh6ZgxJjS57z6Wij4VY");
        log.info("claims:{}", claims);
    }


    /**
     * 有效期为  一个小时  60 * 60 *1000
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L*5;

    /**
     * 设置秘钥明文
     */
    public static final String JWT_KEY = "jwt";

    public static String getUUID () {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成jtw
     *
     * @param subject token中要存放的数据（json格式）
     * @return 返回一个jwt token 类型为 String
     */
    public static String createJWT (String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }

    /**
     * 生成jtw
     *
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return 返回一个jwt token 这里有时间
     */
    public static String createJWT (String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder (String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                //唯一的ID
                .setId(uuid)
                // 主题  可以是JSON数据
                .setSubject(subject)
                // 签发者
                .setIssuer("sg")
                // 签发时间
                .setIssuedAt(now)
                //使用HS256对称加密算法签名, 第二个参数为秘钥
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
    }

    /**
     * 创建token
     *
     * @param id        唯一id
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return 返回一个jwt token 这里有时间
     */
    public static String createJWT (String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }


    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return 返回一个加密后的秘钥
     */
    public static SecretKey generalKey () {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解析
     *
     * @param jwt token
     * @return 返回一个Claims对象
     * @throws Exception 异常
     */
    public static Claims parseJWT (String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

}