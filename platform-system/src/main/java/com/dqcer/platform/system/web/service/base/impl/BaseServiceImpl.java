package com.dqcer.platform.system.web.service.base.impl;

import com.dqcer.platform.system.web.dao.BaseDao;
import com.dqcer.platform.system.web.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基础抽象业务类
 * @author dongQin
 * @data 2019/7/23 23:13
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Autowired(required = false)
    private BaseDao<T, ID> baseDao;

    protected Class<T> aClass;

    public BaseServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        aClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T findById(ID id) {
        return baseDao.findById(id).get();
    }

    @Override
    public T findOne(T t) {
        return baseDao.findOne(Example.of(t)).get();
    }

    @Override
    @Transactional
    @Deprecated
    public T save(T entity) {
        return baseDao.save(entity);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

   /* @Override
    public Page<T> page(PageForm<T> pageForm) {
        return this.findAll(SpecUtil.condition(pageForm), SpecUtil.pageable(pageForm));
    }*/

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return baseDao.findAll(spec, pageable);
    }
}
