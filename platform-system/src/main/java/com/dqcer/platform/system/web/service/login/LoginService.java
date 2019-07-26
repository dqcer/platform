package com.dqcer.platform.system.web.service.login;

import com.dqcer.platform.system.web.vo.login.response.UserInfoResponse;

/**
 * 登录接口
 * @author dongQin
 * @data 2019/7/23 21:45
 */
public interface LoginService {


    /**
     * 根据账号名获取用户信息
     *
     * @param username
     * @return
     */
    UserInfoResponse findUserByName(String username);
}
