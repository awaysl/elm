package com.hanma.elm.controller;

import com.hanma.elm.config.BaseConfig;
import com.hanma.elm.service.IOrderService;
import com.hanma.elm.utils.TokenUtils;
import eleme.openapi.sdk.oauth.response.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth")
public class OAuthController extends BaseConfig {

    @RequestMapping("/getAuthUrl")
    public void getAuthUrl() {
        String authUrl = client.getAuthUrl(redirectUrl + "getTokenByCode", "all", "1234");
        System.out.println(authUrl);
    }


    @RequestMapping("/getTokenByCode")
    public String getTokenByCode(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        System.out.println(code);
        Token token = client.getTokenByCode(code, redirectUrl + "getTokenByCode");
        System.out.println("access_token:" + token.getAccessToken());
        TokenUtils.setTokenInfo(token);
        return "";
    }



}

