package com.yjh.service.impl;

import com.yjh.mapper.RbcMapper;
import com.yjh.mapper.UserMapper;
import com.yjh.pojo.LoginUser;
import com.yjh.pojo.Role;
import com.yjh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RbcMapper rbcMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        User user = userMapper.queryOneUserByUsername(username);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名错误"+user);
        }
        System.out.println("数据库--user信息:"+user);
        Role role = rbcMapper.findRoleByRoleUid(user.getUid());
        List<String> listPermission = rbcMapper.findAllPermissionByRoleId(role.getId());
        if(Objects.isNull(role)||listPermission==null){
            throw new RuntimeException("查询用户权限出现错误"+user);
        }
//        List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
//        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        //把数据封装成UserDetails返回
        return new LoginUser(user,listPermission);
    }
}
