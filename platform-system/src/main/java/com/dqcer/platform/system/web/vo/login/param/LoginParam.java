package com.dqcer.platform.system.web.vo.login.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * 登录请求参数
 * @author dongQin
 * @data 2019/7/23 21:34
 */
@Data
public class LoginParam implements Serializable {

    private static final long serialVersionUID = -398483615393264593L;

    /**
     * 账号名
     */
    @NotEmpty
    private String username;

    /**
     * 密码
     */
    @NotEmpty
    private String password;

}
