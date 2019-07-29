package com.dqcer.platform.system.web.service.base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

    /**
     * 根据Id查询用户
     * @param id
     */
    T findById(ID id);

    /**
     * 根据实体类信息查询
     * @param t
     * @return
     */
    T findOne(T t);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();

    /**
     * 保存一个实体类
     * @param entity
     * @return
     */
    @Deprecated
    T save(T entity);

    /**
     * 分页查询
     * @param form
     * @return
     */
   // Page<T> page(PageForm<T> form);

    /**
     * 按自定义条件分页查询所有实体
     * @param spec
     * @param pageable
     * @return
     */
    //Page<T> findAll(Specification<T> spec, Pageable pageable) ;
}
