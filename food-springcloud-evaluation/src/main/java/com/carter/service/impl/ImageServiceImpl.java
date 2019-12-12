package com.carter.service.impl;

import com.carter.service.ImageService;
import com.carter.utils.FtpUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

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
