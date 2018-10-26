package com.hanma.elm.controller;



import com.hanma.elm.config.BaseConfig;
import com.hanma.elm.entity.order.OMessage;

import com.hanma.elm.service.IOrderService;
import com.hanma.elm.utils.CallbackValidationUtil;
import eleme.openapi.sdk.api.entity.order.OGoodsGroup;
import eleme.openapi.sdk.api.entity.order.OGoodsItem;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseConfig {

    @Autowired
    private IOrderService orderService;


    @RequestMapping("/receiveOrder")
    public void receiveOrder(HttpServletRequest request, HttpServletResponse response)throws IOException {
        int code = 200;
        String responseMessage = "ok";
        OMessage oMessage = null;
        try {
            if ("GET".equals(request.getMethod())) {
                return;
            }
            InputStream is = request.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder body = new StringBuilder();
            while ((line = in.readLine()) != null) {
                body.append(line);
            }
            oMessage = JacksonUtils.json2pojo(body.toString(), OMessage.class);
            if (!CallbackValidationUtil.isValidMessage(oMessage, secret)) {
                throw new Exception("invalid post data : " + body);
            }

        } catch (Exception e) {
            e.printStackTrace();
            code = 500;
            responseMessage = e.getMessage();
        } finally {
            Map<String, String> responseMap = new HashMap<String, String>();
            responseMap.put("message", responseMessage);
            String message = JacksonUtils.obj2json(responseMap);
            response.setStatus(code);
            response.setContentLength(message.length());
            //t.sendResponseHeaders(code, message.length());
            OutputStream os = response.getOutputStream();
            os.write(message.getBytes());
            os.close();

            //type=10的消息，调用确认订单接口完成接单流程
            if (null != oMessage && oMessage.getType() == 10) {
                /*OrderService orderService = new OrderService(config, token);
                OMessage.Message msg = JacksonUtils.json2pojo(oMessage.getMessage(), OMessage.Message.class);
                try {
                    OOrder oOrder = orderService.getOrder(msg.getOrder_id());
                } catch (ServiceException e) {
                    e.printStackTrace();
                }*/
                OMessage.Message msg = JacksonUtils.json2pojo(oMessage.getMessage(), OMessage.Message.class);
                /*System.out.println(oMessage.getMessage());
                System.out.println("orderid:" + msg.getOrderId());*/
                orderService.confirmOrderLite(msg.getOrderId());
            }
        }
    }

    @RequestMapping("/getOrder")
    public void getOrder(HttpServletResponse response, HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        try{
            OOrder oOrder = orderService.getOrder(orderId);
            for(OGoodsGroup group : oOrder.getGroups()){
                for(OGoodsItem item : group.getItems()){
                    System.out.println(item.getName());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping("/confirmOrder")
    public void confirmOrder(HttpServletResponse response, HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        try{
            orderService.confirmOrderLite(orderId);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/cancelOrder")
    public void cancelOrder(HttpServletResponse response, HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        try{
            orderService.cancelOrderLite(orderId);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/agreeRefundLite")
    public void agreeRefundLite(HttpServletResponse response, HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        try{
            orderService.agreeRefundLite(orderId);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/disagreeRefundLite")
    public void disagreeRefundLite(HttpServletResponse response, HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        String reason = request.getParameter("reason");
        try{
            orderService.disagreeRefundLite(orderId, reason);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
