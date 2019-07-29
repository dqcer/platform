package com.dqcer.platform.system.web.vo.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表
 * @author dongQin
 * @data 2019/7/23 21:10
 */
@Data
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 5062614137919272463L;

    /**
     * 主键
     */
    private Integer uid;

    /**
     * 账号名称
     */
    private String username;

    /**
     * 名称（昵称或者真实姓名，不同系统不同定义）
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private byte status;

    /**
     * 用户权限表
     */
    private List<SysRoleEntity> roleList;// 一个用户具有多个角色

    /**
     * 密码盐.
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}
