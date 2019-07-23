package com.dqcer.platformsystem.web.vo.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 资源路径表
 * @author dongQin
 * @data 2019/7/23 21:11
 */
@Data
@Entity(name = "sys_permission")
public class SysPermissionEntity implements Serializable {
    private static final long serialVersionUID = 7655774649047906856L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 主键
     */
    private String name;

    /**
     * 资源类型，[menu|button]
     */
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 是否可用
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 权限资源中间表
     */
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRoleEntity> roles;
}
