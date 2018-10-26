package com.hanma.elm.service;

import com.hanma.elm.config.BaseConfig;
import com.hanma.elm.entity.other.OItemRequest;
import com.hanma.elm.entity.other.OItemRequestChild;
import com.hanma.elm.entity.other.OItemWithPrices;
import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.entity.product.*;
import eleme.openapi.sdk.api.enumeration.product.OItemCreateProperty;
import eleme.openapi.sdk.api.enumeration.product.OItemUpdateProperty;
import eleme.openapi.sdk.api.enumeration.product.OItemWeekEnum;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductServiceImp extends BaseConfig implements IProductService{

    @Autowired
    public IImageService iImageService;

    @Override
    public OCategory createCategory(String name, String description) {
        OCategory oCategory = null;
        try{
            ProductService productService = new ProductService(config, token);
            oCategory = productService.createCategory(shopId, name, description);
        } catch (ServiceException e){
            e.printStackTrace();
        }
        return oCategory;
    }

    @Override
    public OItem createItem(OItemRequest oItemRequest) {
        try{
            //先将图片base64上传获取图片hash值
            //OItemRequest.OItemRq oItemRq = JacksonUtils.json2pojo(oItemRequest.getoItem(), OItemRequest.OItemRq.class);
            OItemRequestChild oItemRq = oItemRequest.getoItem();
            String imageHash = iImageService.uploadImage(oItemRq.getImgBase64());

            ProductService productService = new ProductService(config, token);
            Map<OItemCreateProperty,Object> properties = new HashMap<OItemCreateProperty,Object>();
            properties.put(OItemCreateProperty.name, oItemRq.getName());
            properties.put(OItemCreateProperty.description, oItemRq.getDescription());
            properties.put(OItemCreateProperty.imageHash, imageHash);
            properties.put(OItemCreateProperty.labels, oItemRq.getLabels());
            properties.put(OItemCreateProperty.specs, oItemRq.getSpecs());
            properties.put(OItemCreateProperty.sellingTime, oItemRq.getSellingTime());
            properties.put(OItemCreateProperty.attributes, oItemRq.getAttributes());
            properties.put(OItemCreateProperty.backCategoryId, null);
            properties.put(OItemCreateProperty.minPurchaseQuantity, 1);
            properties.put(OItemCreateProperty.unit, "份");
            properties.put(OItemCreateProperty.setMeal, 1);
            /*List<String> list50 = new ArrayList<String>();

            list50.add(example);*/
            properties.put(OItemCreateProperty.imageHashs, null);
            /*List<OMaterial> oMaterials = new ArrayList<OMaterial>();
            OMaterial oMaterial = new OMaterial();
            oMaterial.setId(1000L);
            oMaterial.setName("鸡蛋");
            oMaterials.add(oMaterial);
            properties.put(OItemCreateProperty.materials,oMaterials);*/
            productService.createItem(oItemRequest.getCategoryId(), properties);
        } catch (ServiceException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Long, OItem> getItemsByCategoryId(long categoryId) {
        Map<Long, OItem> map = new HashMap<>();
        ProductService productService = new ProductService(config, token);
        try{
            map = productService.getItemsByCategoryId(categoryId);
        } catch (ServiceException e){
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public OItem updateItem(OItemRequest oItemRequest) {
        try{
            //先将图片base64上传获取图片hash值
            //OItemRequest.OItemRq oItemRq = JacksonUtils.json2pojo(oItemRequest.getoItem(), OItemRequest.OItemRq.class);
            OItemRequestChild oItemRq = oItemRequest.getoItem();
            String imageHash = iImageService.uploadImage("");

            ProductService productService = new ProductService(config, token);
            Map<OItemUpdateProperty,Object> properties = new HashMap<OItemUpdateProperty,Object>();
            properties.put(OItemUpdateProperty.name, oItemRq.getName());
            properties.put(OItemUpdateProperty.description, oItemRq.getDescription());
            properties.put(OItemUpdateProperty.imageHash, imageHash);
            properties.put(OItemUpdateProperty.labels, oItemRq.getLabels());
            properties.put(OItemUpdateProperty.specs, oItemRq.getSpecs());
            properties.put(OItemUpdateProperty.sellingTime, oItemRq.getSellingTime());
            properties.put(OItemUpdateProperty.attributes, oItemRq.getAttributes());
            properties.put(OItemUpdateProperty.backCategoryId, null);
            properties.put(OItemUpdateProperty.minPurchaseQuantity, 1);
            properties.put(OItemUpdateProperty.unit, "份");
            properties.put(OItemUpdateProperty.setMeal, 1);
            /*List<String> list50 = new ArrayList<String>();

            list50.add(example);*/
            properties.put(OItemUpdateProperty.imageHashs, null);
            /*List<OMaterial> oMaterials = new ArrayList<OMaterial>();
            OMaterial oMaterial = new OMaterial();
            oMaterial.setId(1000L);
            oMaterial.setName("鸡蛋");
            oMaterials.add(oMaterial);
            properties.put(OItemCreateProperty.materials,oMaterials);*/
            productService.updateItem(oItemRequest.getItemId(), oItemRequest.getCategoryId(), properties);
        } catch (ServiceException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OItem batchCreateItems(OItemRequest oItemRequest) {
        try{
            List<Map<OItemCreateProperty, Object>> list = new ArrayList<>();
            ProductService productService = new ProductService(config, token);
            for(OItemRequestChild oItemRq : oItemRequest.getoItems()){
                //先将图片base64上传获取图片hash值
                //OItemRequest.OItemRq oItemRq = JacksonUtils.json2pojo(oItemRequest.getoItem(), OItemRequest.OItemRq.class);
                //OItemRequestChild oItemRq = oItemRequest.getoItem();
                String imageHash = iImageService.uploadImage("");


                Map<OItemCreateProperty,Object> properties = new HashMap<OItemCreateProperty,Object>();
                properties.put(OItemCreateProperty.name, oItemRq.getName());
                properties.put(OItemCreateProperty.description, oItemRq.getDescription());
                properties.put(OItemCreateProperty.imageHash, imageHash);
                properties.put(OItemCreateProperty.labels, oItemRq.getLabels());
                properties.put(OItemCreateProperty.specs, oItemRq.getSpecs());
                properties.put(OItemCreateProperty.sellingTime, oItemRq.getSellingTime());
                properties.put(OItemCreateProperty.attributes, oItemRq.getAttributes());
                properties.put(OItemCreateProperty.backCategoryId, null);
                properties.put(OItemCreateProperty.minPurchaseQuantity, 1);
                properties.put(OItemCreateProperty.unit, "份");
                properties.put(OItemCreateProperty.setMeal, 1);
                properties.put(OItemCreateProperty.imageHashs, null);
                list.add(properties);
                //productService.updateItem(oItemRequest.getItemId(), oItemRequest.getCategoryId(), properties);
            }
            productService.batchCreateItems(oItemRequest.getCategoryId(), list);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void batchUpdatePrices(OItemWithPrices oItemWithPrices) {
        try{
            ProductService productService = new ProductService(config, token);
            productService.batchUpdatePrices(oItemWithPrices.getShopId(), oItemWithPrices.getList());
        } catch (ServiceException e){
            e.printStackTrace();
        }
    }
}
