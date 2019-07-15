package com.dqcer.platformsystem.web.dao.user;

import com.dqcer.platformsystem.web.vo.user.entity.UserInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfoEntity,Long>  {
}
