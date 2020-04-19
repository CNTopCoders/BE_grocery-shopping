package com.alias.uploadcet.authentication;

import com.alias.uploadcet.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description : 下发token
 * @Author : ZGS
 * @Date: 2020-04-12 16:52
 */
@Service
public class TokenService {
    public String getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token;
        token = JWT.create().withAudience(user.getUserId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getOpenId()));
        return token;
    }
    public String getTokenByParam(String userId,String openId) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token;
        token = JWT.create().withAudience(userId).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(openId));
        return token;
    }
}
