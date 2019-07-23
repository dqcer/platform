package com.dqcer.platformsystem.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * 数据操作的工具类
 * @author dongQin
 * @data 2019/7/23 22:06
 */
@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * 根据多个ID查询实体
     *
     * @param ids
     * @return
     */
    //List<T> findById(List<ID> ids);

}
