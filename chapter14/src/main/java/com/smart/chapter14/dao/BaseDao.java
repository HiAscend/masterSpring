package com.smart.chapter14.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * BaseDao
 *
 * @author ascend
 * @date 2017/11/27 15:08.
 */
public class BaseDao<T> {
    private HibernateTemplate hibernateTemplate;
    private Class entityClass;

    public BaseDao() {
        Type type = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    public T get(Serializable id) {
        return (T)hibernateTemplate.get(entityClass, id);
    }

    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    public void update(T entity) {
        hibernateTemplate.update(entity);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
