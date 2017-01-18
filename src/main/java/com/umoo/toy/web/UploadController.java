package com.umoo.toy.web;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/19.
 */
@RestController
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/upload")
    public String upload(MultipartFile file) {
        try {
            FileUtils.writeByteArrayToFile(new File(file.getOriginalFilename()), file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
