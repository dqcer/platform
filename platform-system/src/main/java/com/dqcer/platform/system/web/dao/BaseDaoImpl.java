package com.dqcer.platform.system.web.dao;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public abstract class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {



}
