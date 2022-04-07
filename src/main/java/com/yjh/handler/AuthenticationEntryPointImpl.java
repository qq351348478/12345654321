package com.yjh.handler;

import com.alibaba.fastjson.JSON;
import com.yjh.domain.ResponseResult;
import com.yjh.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    ResponseResult result=null;
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (authException instanceof AccountExpiredException) {
            //账号过期
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"账号过期");

        } else if (authException instanceof BadCredentialsException) {
            //密码错误
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"账号或者密码错误");

        } else if (authException instanceof CredentialsExpiredException) {
            //密码过期
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"密码国旗");

        } else if (authException instanceof DisabledException) {
            //账号不可用
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"账号不可用");

        } else if (authException instanceof LockedException) {
            //账号锁定
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"账号锁定");


        } else if (authException instanceof InternalAuthenticationServiceException) {
            //用户不存在
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户不存在");

        }else{
             result = new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户认证失败请查询登录");

        }
        System.out.println(authException);
        String json = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,json);
    }
}
