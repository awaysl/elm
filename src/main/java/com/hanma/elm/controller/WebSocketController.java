package com.hanma.elm.controller;

import com.hanma.elm.config.BaseConfig;
import com.hanma.elm.entity.order.OMessage;
import com.hanma.elm.utils.CallbackValidationUtil;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.utils.JacksonUtils;
import eleme.openapi.ws.sdk.Bootstrap;
import eleme.openapi.ws.sdk.config.BusinessHandle;
import eleme.openapi.ws.sdk.config.Config;
import eleme.openapi.ws.sdk.config.ElemeSdkLogger;
import eleme.openapi.ws.sdk.entity.Account;
import eleme.openapi.ws.sdk.exception.UnableConnectionException;

import java.util.ArrayList;
import java.util.List;

public class WebSocketController extends BaseConfig {

    private static OrderService orderService = new OrderService(config, token);
    //全双工模式接收推送消息
    public static void start() {
        Account account = new Account(key, secret);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(account);
        Config config = new Config(accounts,
                new BusinessHandle() {
                    @Override
                    public boolean onMessage(String message) {
                        try{
                            OMessage oMessage = JacksonUtils.json2pojo(message, OMessage.class);
                            if (!CallbackValidationUtil.isValidMessage(oMessage, secret)) {
                                throw new Exception("invalid post data : " + message);
                            }
                            //type=10的消息，调用确认订单接口完成接单流程
                            if (null != oMessage && oMessage.getType() == 10) {
                                OMessage.Message msg = JacksonUtils.json2pojo(oMessage.getMessage(), OMessage.Message.class);
                                System.out.println(oMessage.getMessage());
                                System.out.println("orderid:" + msg.getOrderId());
                                orderService.confirmOrderLite(msg.getOrderId());
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                            return false;
                        }
                        //你的业务消息处理,推荐直接落地存储,不要耦合过重业务

                        return true;
                    }
                },
                new ElemeSdkLogger() {
                    @Override
                    public void info(String message) {
                        //your info log 处理
                    }

                    @Override
                    public void error(String message) {
                        //your error log 处理
                    }
                }
        );
        try {
            Bootstrap.start(config);
        } catch (UnableConnectionException e) {
            e.printStackTrace();
        }
    }
}
