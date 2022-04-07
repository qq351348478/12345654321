package com.yjh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 用户表(User)实体类
 *
 * @author 三更
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
//    private static final long serialVersionUID = -40356785423868312L;

    /**
     * 主键
     */
    private Long uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;
//    /**
//     * 账号状态（0正常 1停用）
//     */
//    private String status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 头像
     */
    private String avatar;
//    /**
//     * 用户类型（0管理员，1普通用户）
//     */
//    private String userType;
    /**
     * 创建时间
     */
    private Date createTime;
}