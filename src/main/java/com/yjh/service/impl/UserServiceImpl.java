package com.yjh.service.impl;

import com.yjh.domain.ResponseResult;
import com.yjh.mapper.RbcMapper;
import com.yjh.mapper.UserMapper;
import com.yjh.pojo.User;
import com.yjh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RbcMapper rbcMapper;

    @Override
    public ResponseResult insertOneUser(User user) {
        if (user.getUsername()==null){
            return new ResponseResult(500,"用户名不能为空！！");
        }
        if (user.getPassword()==null){
            return new ResponseResult(500,"密码不能为空！！");
        }
        if(!Pattern.matches("^[a-zA-Z0-9]{8,15}$",user.getUsername()))
            return new ResponseResult(500,"账号只能有数字和字母，长度8到15");
        if(!Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,15}$",user.getPassword()))
            return new ResponseResult(500,"密码必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-15 之间");
        if (user.getNickName()==null){
            return new ResponseResult(500,"昵称不能为空！！");

        }
        User user1 = userMapper.queryOneUserByUsername(user.getUsername());
        if(user1!=null){
            return new ResponseResult(500,"用户名已存在！！");
        }
        String password = user.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encodePassword);
        Integer count = userMapper.insertUser(user);
        if(count == 0){
            return new ResponseResult(500,"注册失败，插入角色失败！");
        }
        if(user.getUid() == null){
            return new ResponseResult(500,"注册失败，未知原因！");
        }
        Integer integer = rbcMapper.insertDefaultRole(user.getUid());
        if (integer==0){
            return new ResponseResult(500,"插入权限失败");
        }
        return new ResponseResult(200,"注册成功！");
    }
}
