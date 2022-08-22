package com.nxg.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author nxg
 * date 2022/7/29
 * @apiNote
 */
@Controller
public class DownLoadController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> down(String filename, HttpServletRequest request) throws UnsupportedEncodingException, IOException {
        //1. 转换服务器地址
        String realPath = request.getRealPath("/uploadImg");
        System.out.println(realPath);
        //2.得到要下载文件的路径
        String filePath = realPath+"/"+filename;
        System.out.println(filePath);
        //3.设置响应的头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //给用户弹窗的方式下载
        //attachment 用来表示以附件的方式响应给客户端
        httpHeaders.setContentDispositionFormData("attachment", URLEncoder.encode(filename,"UTF-8"));
        //4.创建文件
        File file = new File(filePath);
        //5.将文件进行返回
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);
        return  responseEntity;
    }
}
