package com.yjh.controller;

import com.yjh.domain.ResponseResult;
import com.yjh.pojo.User;
import com.yjh.service.LoginServcie;
import com.yjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;
    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        System.out.println("controller--user:"+user);
        //登录
        return loginServcie.login(user);
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseResult register(@RequestBody User user){
        return userService.insertOneUser(user);
    }


    @PreAuthorize("hasAnyAuthority('sys:browse','sys:all')")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ResponseResult logout(){
        return loginServcie.logout();
    }
}
