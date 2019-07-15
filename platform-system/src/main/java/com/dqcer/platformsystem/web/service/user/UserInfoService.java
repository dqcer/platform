package com.dqcer.platformsystem.web.service.user;

import com.dqcer.platformsystem.web.vo.user.entity.UserInfoEntity;

/**
 * user info
 * @author dongQin
 * @data 2019/7/15 21:50
 */
public interface UserInfoService {

    UserInfoEntity findByUsername(String username);
}
