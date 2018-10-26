package com.hanma.elm.entity.other;

import eleme.openapi.sdk.api.entity.product.OItemIdWithSpecPrice;

import java.util.List;

public class OItemWithPrices {
    private long shopId;

    private List<OItemIdWithSpecPrice> list;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public List<OItemIdWithSpecPrice> getList() {
        return list;
    }

    public void setList(List<OItemIdWithSpecPrice> list) {
        this.list = list;
    }
}
