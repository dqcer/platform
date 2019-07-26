package com.dqcer.platform.system.web.vo.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 权限表
 * @author dongQin
 * @data 2019/7/23 21:10
 */
@Data
@Entity(name = "sys_role")
public class SysRoleEntity implements Serializable {

    private static final long serialVersionUID = -508263910902538845L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的:
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 角色 -- 权限关系：多对多关系;
     */
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermissionEntity> permissions;

    /**
     *  用户 - 角色关系定义：多对多关系
     */
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<UserInfoEntity> userInfos;// 一个角色对应多个用户
}
