package com.xzk.interceptor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件后缀处理拦截器
 */
public class FileInterceptor implements HandlerInterceptor {
    /**
     * 在文件上传之前判断后缀是否合法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否是文件上传的请求
        boolean flag = true;
        if (request instanceof MultipartHttpServletRequest){
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            //遍历文件
            Iterator<String> iterator = fileMap.keySet().iterator();
            while(iterator.hasNext()){
                String key = iterator.next();
                MultipartFile file = multipartRequest.getFile(key);
                String originalFilename = file.getOriginalFilename();
                String hz = originalFilename.substring(originalFilename.lastIndexOf("."));
                //判断后缀是否合法
                if (!hz.toLowerCase().equals(".png") && !hz.toLowerCase().equals(".jpg")){
                    request.getRequestDispatcher("/jsp/fileTypeError.jsp").forward(request,response);
                    flag=false;
                }
            }
        }
        return flag;
    }
}
