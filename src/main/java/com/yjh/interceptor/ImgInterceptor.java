package com.yjh.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;


@Slf4j
//对图片名为中文的编码进行解码
public class ImgInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}",requestURI);

        if(request.getMethod().equals("get")){
            String decode = URLDecoder.decode(requestURI, "UTF-8");
            request.getRequestDispatcher(decode).forward(request,response);

        }
//
//        //登录检查逻辑
//        HttpSession session = request.getSession();
//        if(session.getAttribute("loginUser")==null){
//            return false;
//        }
        return true;
    }
}
