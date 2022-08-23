package com.xzk.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 文件上传
 */
@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        //指定文件的路径
        String path = request.getServletContext().getRealPath("/uploadFile")+"/3de393cdc0624569a1dcb938b10a0a74.jpg";
        //创建响应 的头信息的对象
        HttpHeaders headers = new HttpHeaders();
        //标记以流的方式做出响应
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //以附件的形式响应给用户
        headers.setContentDispositionFormData("attachment", URLEncoder.encode("3de393cdc0624569a1dcb938b10a0a74.jpg","utf-8"));
        File file = new File(path);
        ResponseEntity<byte[]> resp = new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
        return resp;
    }

    /**
     * 文件上传
     * @param myFile
     * @param request
     * @return
     */
    @RequestMapping("upload")
    public String upload(@RequestParam("myFile") MultipartFile myFile, HttpServletRequest request){
        //获取文件的原始名称 d:\te.add\txcat.jpg
        String originalFilename = myFile.getOriginalFilename();
        //实际开发中,一般都要将文件重新命名 进行存储
        //存储到服务器的文件名称=随机的字符串+根据实际名称获取到源文件的后缀
       String fileName = UUID.randomUUID().toString().replace("-","") + originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("文件重新命名的名称"+fileName);
        //文件储存路径
        String realPath = request.getServletContext().getRealPath("/uploadFile")+"/";
        try {
            myFile.transferTo(new File(realPath+fileName));
            System.out.println("上传成功!"+realPath+fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
    @RequestMapping("hello")
    public String hello(){
        return "fileHandel";
    }
}
