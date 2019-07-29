package com.dqcer.platform.system.web.vo.user.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 资源路径表
 * @author dongQin
 * @data 2019/7/23 21:11
 */
@Data
public class SysPermissionEntity implements Serializable {
    private static final long serialVersionUID = 7655774649047906856L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 主键
     */
    private String name;

    /**
     * 资源类型，[menu|button]
     */
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
    private List<SysRoleEntity> roles;
}
