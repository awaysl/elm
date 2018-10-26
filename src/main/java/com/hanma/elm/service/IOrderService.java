package com.hanma.elm.service;

import eleme.openapi.sdk.api.entity.order.OOrder;

public interface IOrderService {
    public OOrder getOrder(String orderId);

    public void confirmOrderLite(String orderId);

    public void cancelOrderLite(String orderId);

    public void agreeRefundLite(String orderId);

    public void disagreeRefundLite(String orderId, String reason);
}
