package com.dqcer.platform.system.web.service.login.impl;

import com.dqcer.platform.system.web.service.base.impl.BaseServiceImpl;
import com.dqcer.platform.system.web.service.login.LoginService;
import com.dqcer.platform.system.web.vo.login.response.UserInfoResponse;
import com.dqcer.platform.system.web.vo.user.entity.UserInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 登录实现类
 * @author dongQin
 * @data 2019/7/23 21:46
 */
@Slf4j
@Service
public class LoginServiceImpl extends BaseServiceImpl<UserInfoEntity, Integer> implements LoginService {



    /**
     * 根据账号名获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public UserInfoResponse findUserByName(String username) {
        UserInfoEntity entity = new UserInfoEntity();
        entity.setName(username);
        UserInfoEntity one = findOne(entity);
        // TODO: 2019/7/23
        UserInfoResponse response = (UserInfoResponse) one;
        return response;
    }


}
