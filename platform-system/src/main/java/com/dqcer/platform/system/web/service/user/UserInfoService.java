package com.dqcer.platform.system.web.service.user;

import com.dqcer.platform.system.web.vo.user.entity.UserInfoEntity;

/**
 * user info
 * @author dongQin
 * @data 2019/7/15 21:50
 */
public interface UserInfoService {

    UserInfoEntity findByUsername(String username);
}
