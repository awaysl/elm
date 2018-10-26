package com.hanma.elm.controller;

import com.hanma.elm.entity.other.OItemRequest;
import com.hanma.elm.entity.other.OItemWithPrices;
import com.hanma.elm.service.IProductService;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.enumeration.product.OItemCreateProperty;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("/createCategory")
    public void createCategory(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        OCategory oCategory = iProductService.createCategory(name, description);
        System.out.println(oCategory.getId());
    }

    @RequestMapping("/createItem")
    public void createItem(HttpServletRequest request, HttpServletResponse response){
        try{
            InputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            /*long categoryId = 1247817258L;
            Map<OItemCreateProperty, Object> map = new HashMap<>();
            OItem oItem = iProductService.createItem(categoryId, map);*/
            OItemRequest oItemRequest = JacksonUtils.json2pojo(sb.toString(), OItemRequest.class);
            OItem oItem = iProductService.createItem(oItemRequest);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/batchCreateItems")
    public void batchCreateItems(HttpServletRequest request, HttpServletResponse response){
        try{
            InputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            OItemRequest oItemRequest = JacksonUtils.json2pojo(sb.toString(), OItemRequest.class);
            OItem oItem = iProductService.batchCreateItems(oItemRequest);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateItem")
    public void updateItem(HttpServletRequest request, HttpServletResponse response){
        InputStream inputStream = null;
        try{
            inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            OItemRequest oItemRequest = JacksonUtils.json2pojo(sb.toString(), OItemRequest.class);
            OItem oItem = iProductService.updateItem(oItemRequest);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/getItemsByCategoryId")
    public void getItemsByCategoryId(HttpServletRequest request, HttpServletResponse response){
        long categoryId = Long.valueOf(request.getParameter("categoryId"));
        Map<Long, OItem> map = iProductService.getItemsByCategoryId(categoryId);
        for(long subcategoryId : map.keySet()){
            System.out.println(map.get(subcategoryId).getId());
            System.out.println(map.get(subcategoryId).getSpecs().get(0).getSpecId());
        }
    }

    @RequestMapping("/batchUpdatePrices")
    public void batchUpdatePrices(HttpServletRequest request, HttpServletResponse response){
        InputStream inputStream = null;
        try{
            inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuffer sb = new StringBuffer();
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            OItemWithPrices oItemWithPrices = JacksonUtils.json2pojo(sb.toString(), OItemWithPrices.class);
            iProductService.batchUpdatePrices(oItemWithPrices);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                inputStream.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}