package com.hanma.elm.service;

import com.hanma.elm.config.BaseConfig;
import com.hanma.elm.utils.TokenUtils;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.enumeration.order.OInvalidateType;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.OrderService;
import eleme.openapi.sdk.utils.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImp extends BaseConfig implements IOrderService {
    @Override
    public OOrder getOrder(String orderId) {
        OOrder oOrder = null;
        try{
            if(StringUtils.isEmpty(token.getAccessToken())){
                token = TokenUtils.getToken();
            }
            OrderService orderService = new OrderService(config, token);
            oOrder = orderService.getOrder(orderId);
        } catch (ServiceException e){
            e.printStackTrace();
        }
        return oOrder;
    }

    @Override
    public void cancelOrderLite(String orderId) {
        try{
            if(StringUtils.isEmpty(token.getAccessToken())){
                token = TokenUtils.getToken();
            }
            OrderService orderService = new OrderService(config, token);
            orderService.cancelOrderLite(orderId, OInvalidateType.others, "");
        } catch (ServiceException e){
            e.printStackTrace();
        }
    }

    @Override
    public void confirmOrderLite(String orderId) {
        try{
            if(StringUtils.isEmpty(token.getAccessToken())){
                token = TokenUtils.getToken();
            }
            OrderService orderService = new OrderService(config, token);
            orderService.confirmOrderLite(orderId);
        } catch (ServiceException e){
            e.printStackTrace();
        }
    }

    @Override
    public void agreeRefundLite(String orderId) {
        try{
            if(StringUtils.isEmpty(token.getAccessToken())){
                token = TokenUtils.getToken();
            }
            OrderService orderService = new OrderService(config, token);
            orderService.agreeRefundLite(orderId);
        } catch (ServiceException e){
            e.printStackTrace();
        }
    }

    @Override
    public void disagreeRefundLite(String orderId, String reason) {
        try{
            if(StringUtils.isEmpty(token.getAccessToken())){
                token = TokenUtils.getToken();
            }
            OrderService orderService = new OrderService(config, token);
            orderService.disagreeRefundLite(orderId, reason);
        } catch (ServiceException e){
            e.printStackTrace();
        }
    }
}
