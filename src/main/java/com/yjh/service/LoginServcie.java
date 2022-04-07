package com.yjh.service;

import com.yjh.domain.ResponseResult;
import com.yjh.pojo.User;

public interface LoginServcie {
    ResponseResult login(User user);

    ResponseResult logout();

}
