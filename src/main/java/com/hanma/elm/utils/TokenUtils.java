package com.hanma.elm.utils;

import eleme.openapi.sdk.oauth.response.Token;
import eleme.openapi.sdk.utils.PropertiesUtils;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    public static Token getToken() {
        String access_token = PropertiesUtils.getPropValueByKey("access_token");
        String token_type = PropertiesUtils.getPropValueByKey("token_type");
        String expires_in = PropertiesUtils.getPropValueByKey("expires_in");
        String refresh_token = PropertiesUtils.getPropValueByKey("refresh_token");
        if (access_token.isEmpty()) {
            System.out.println("access_token is null");
            return null;
        }
        Token token = new Token();
        token.setAccessToken(access_token);
        token.setTokenType(token_type);
        token.setExpires(Long.valueOf(expires_in));
        token.setRefreshToken(refresh_token);
        return token;
    }

    public static void setTokenInfo(Token token) {
        if (null != token && token.isSuccess()) {
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("access_token", token.getAccessToken());
            tokenMap.put("token_type", token.getTokenType());
            tokenMap.put("expires_in", String.valueOf(token.getExpires()));
            tokenMap.put("refresh_token", token.getRefreshToken());
            PropertiesUtils.setProps(tokenMap);
        }
    }


    /*public Token refreshToken() {
        Token freshToken = client.getTokenByRefreshToken(token.getRefreshToken());
        TokenUtils.setTokenInfo(freshToken);
        return token;
    }*/
}
