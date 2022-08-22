package com.nxg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author nxg
 * date 2022/7/29
 * @apiNote
 */
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile myfile, HttpServletRequest request){
        //处理文件内容
        //1.    将上传的文件夹转换为服务器路径
        String realPath = request.getRealPath("/uploadImg");
        System.out.println("realPath="+realPath);
        //2.    得到上传的文件名
        String originalFilename = myfile.getOriginalFilename();
        //3.    上传文件
        try {
            myfile.transferTo(new File(realPath+"/"+originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        request.setAttribute("filename",originalFilename);
        return "uploadsuccess";
    }
}
