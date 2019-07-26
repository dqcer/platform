package com.dqcer.platform.system.web.service.user.impl;

import com.dqcer.platform.system.web.service.user.UserInfoService;
import com.dqcer.platform.system.web.vo.user.entity.UserInfoEntity;
import org.springframework.stereotype.Service;

/***
 *
 * @author dongQin
 * @data 2019/7/15 22:05
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserInfoEntity findByUsername(String username) {
        return null;
    }
}
