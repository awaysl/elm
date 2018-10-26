package com.hanma.elm.service;

import com.hanma.elm.config.BaseConfig;
import eleme.openapi.sdk.api.annotation.Service;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.utils.Base64;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class ImageServiceImp extends BaseConfig implements IImageService{

    private static ProductService productService;

    static {
        productService = new ProductService(config, token);
    }


    @Override
    public String uploadImage(String imageBase64Str) {
        String imageHash = "";
        InputStream is = null;
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try{
            if(imageBase64Str.equals("")){
                is = new FileInputStream(new File("E:\\testImg\\2t.jpg"));
                byte[] bytes = new byte[1024];
                int length = 0;
                BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
                while((length = bufferedInputStream.read(bytes)) != -1){
                    data.write(bytes, 0, length);
                }
                imageBase64Str = Base64.encodeToString(data.toByteArray(), false);
            }
            //ProductService productService = new ProductService(config, token);
            imageHash = productService.uploadImage(imageBase64Str);
            System.out.println(imageHash);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ServiceException e){
            e.printStackTrace();
        } finally {
            try{
                is.close();
                data.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }
        return imageHash;
    }

    @Override
    public List<String> uploadImages() {
        return null;
    }
}
