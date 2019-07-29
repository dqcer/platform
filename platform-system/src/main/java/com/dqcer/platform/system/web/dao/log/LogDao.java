package com.dqcer.platform.system.web.dao.log;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dqcer.platform.system.web.vo.log.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 日志操作
 * @Author dongqin
 * @Description
 * @Date 11:34 2019/7/26
 */
@Mapper
@Repository
public interface LogDao extends BaseMapper<SysLogEntity> {
}
