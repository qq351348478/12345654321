package com.yjh.mapper;

import com.yjh.pojo.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RbcMapper {
    @Insert("insert into user_role(uid,role_id) values(#{uid},1)")
    Integer insertDefaultRole(Long uid);


    List<String> findAllPermissionByRoleId(Long rid);

    Role findRoleByRoleUid(Long uid);

}
