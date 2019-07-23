package com.dqcer.platformsystem.web.vo.login.response;

import com.dqcer.platformsystem.web.vo.user.entity.UserInfoEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录返回类
 * @author dongQin
 * @data 2019/7/23 21:49
 */
@Data
public class UserInfoResponse extends UserInfoEntity implements Serializable {

    private static final long serialVersionUID = -1666353758149634281L;

}
