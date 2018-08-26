package com.springboot.javaee.chapter4.upload;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26下午12:29
 */
@Controller
public class UploadController {

    @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
    public @ResponseBody
    String upload(MultipartFile multipartFile, HttpServletRequest request) {
        try {
            String filePath = request.getContextPath();
            System.out.println("filePath" + filePath);
            File file = new File(filePath + multipartFile.getOriginalFilename());
            //写入磁盘
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
