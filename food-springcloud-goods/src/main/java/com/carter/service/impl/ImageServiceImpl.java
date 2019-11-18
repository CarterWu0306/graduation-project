package com.carter.service.impl;

import com.carter.service.ImageService;
import com.carter.utils.Base64Util;
import com.carter.utils.FtpUtil;
import com.carter.utils.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String recognizeImage(MultipartFile file) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";

        if (file!=null){
            try {
                byte[] imgData = file.getBytes();
                String imgStr = Base64Util.encode(imgData);
                String imgParam = URLEncoder.encode(imgStr, "UTF-8");

                String param = "image=" + imgParam;

                String accessToken = "24.13725b1da233b1691b77ec816ff2a068.2592000.1573606982.282335-17494867";

                String result = HttpUtil.post(url, accessToken, param);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "识别失败";
        }else{
            return "文件为空";
        }
    }

    @Override
    public String uploadImage(MultipartFile file, String defaultImage) throws IOException {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        File tempFile = File.createTempFile(UUID.randomUUID().toString(), prefix);
        // MultipartFile to File
        file.transferTo(tempFile);

        FileInputStream in=new FileInputStream(tempFile);
        boolean result = FtpUtil.uploadFile(tempFile.getName(), in);
        tempFile.delete();
        if (result){
            return "http://images.wukate.com/" + tempFile.getName();
        }else{
            return defaultImage;
        }
    }
}
