package com.hanma.elm.service;

import java.util.List;

public interface IImageService {
    public String uploadImage(String imgBase64);

    public List<String> uploadImages();
}
