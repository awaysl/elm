package com.hanma.elm.entity.other;

import eleme.openapi.sdk.api.entity.product.*;
import eleme.openapi.sdk.api.enumeration.product.ItemType;

import java.util.List;

public class OItemRequest {
    public long categoryId;

    public long itemId;

    public OItemRequestChild oItem;

    public List<OItemRequestChild> oItems;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public OItemRequestChild getoItem() {
        return oItem;
    }

    public void setoItem(OItemRequestChild oItem) {
        this.oItem = oItem;
    }

    public List<OItemRequestChild> getoItems() {
        return oItems;
    }

    public void setoItems(List<OItemRequestChild> oItems) {
        this.oItems = oItems;
    }
}
