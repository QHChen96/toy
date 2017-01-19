package com.umoo.toy.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/1/19.
 */
@RestController
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/upload")
    public String upload(MultipartFile file) {
    	if(!file.isEmpty()) {
	        try {
	        	logger.info("Upload:" + file.getOriginalFilename());
	        	BufferedOutputStream out = new BufferedOutputStream(
	        			new FileOutputStream(new File(file.getOriginalFilename())));
	        	out.write(file.getBytes());	
	        	out.flush();
	        	out.close();
	            //FileUtils.writeByteArrayToFile(new File(file.getOriginalFilename()), file.getBytes());
	            return "ok";
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    	}
		return "ok";
    }
}
