package com.yjh.mapper;

import com.yjh.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{

    @Select("select * from sys_user where username = #{username}")
    User queryOneUserByUsername(String username);


    Integer insertUser(User user);


}
