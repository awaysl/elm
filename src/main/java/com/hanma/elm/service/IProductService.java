package com.hanma.elm.service;

import com.hanma.elm.entity.other.OItemRequest;
import com.hanma.elm.entity.other.OItemWithPrices;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.enumeration.product.OItemCreateProperty;

import java.util.Map;

public interface IProductService {
    public OCategory createCategory(String name, String description);

    public OItem createItem(OItemRequest oItemRequest);

    public Map<Long, OItem> getItemsByCategoryId(long categoryId);

    public OItem updateItem(OItemRequest oItemRequest);

    public OItem batchCreateItems(OItemRequest oItemRequest);

    public void batchUpdatePrices(OItemWithPrices oItemWithPrices);
}
