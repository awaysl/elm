package com.hanma.elm.config;

import com.hanma.elm.controller.WebSocketController;
import com.hanma.elm.utils.TokenUtils;
import eleme.openapi.sdk.config.Config;
import eleme.openapi.sdk.oauth.OAuthClient;
import eleme.openapi.sdk.oauth.response.Token;

import java.util.HashMap;
import java.util.Map;

public class BaseConfig {
    // 设置是否沙箱环境
    protected static final boolean isSandbox = true;
    // 设置APPKEY
    protected static final String key = "9L1aoD6b3X";
    // 设置APPSECRET
    protected static final String secret = "1e98ad4236ff4f9f430e08d7f1bab69c6fad0910";
    // 初始化OAuthClient
    protected static OAuthClient client = null;
    // 回调地址
    protected static final String redirectUrl = "https://6963707b.ngrok.io/oauth/";

    protected static final long shopId = 163007916L;

    protected static Config config = null;

    protected static Token token = null;

    static {
        // 初始化全局配置工具
        config = new Config(isSandbox, key, secret);
        client = new OAuthClient(config);
        token = TokenUtils.getToken();
        WebSocketController.start();
    }
}
