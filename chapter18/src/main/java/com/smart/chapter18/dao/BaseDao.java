package com.smart.chapter18.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * BaseDao
 * DAO基类，其它DAO可以直接继承这个DAO，不但可以复用共用的方法，还可以获得泛型的好处。
 *
 * @author zziaa
 * @date 2018/04/23 20:28
 */
public class BaseDao<T> {
    private Class<T> entityClass;
    private HibernateTemplate hibernateTemplate;

    /**
     * 通过反射获取子类确定的泛型类
     */
    @SuppressWarnings("unchecked")
    public BaseDao() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        entityClass = (Class<T>) params[0];
    }

    /**
     * 根据ID加载PO实例
     *
     * @param id 主键
     * @return 实例对象，如果记录不存在，返回null
     */
    public T load(Serializable id) {
        return getHibernateTemplate().load(entityClass, id);
    }

    /**
     * 根据ID加载PO实例
     *
     * @param id 主键
     * @return 实例对象，如果记录不存在，返回null
     */
    public T get(Serializable id) {
        return getHibernateTemplate().load(entityClass, id);
    }

    /**
     * 获取PO的所有对象
     *
     * @return List
     */
    public List<T> loadAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    /**
     * 保存PO
     *
     * @param entity T
     */
    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    /**
     * 删除PO
     *
     * @param entity T
     */
    public void remove(T entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * 清空表中的所有数据，谨慎使用
     *
     * @param tableName String
     */
    public void removeAll(String tableName) {
        getSession().createSQLQuery("truncate table " + tableName).executeUpdate();
    }

    /**
     * 更改PO
     *
     * @param entity T
     */
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    /**
     * 执行hql查询
     *
     * @param hql hql语句
     * @return List
     */
    public List find(String hql) {
        return getHibernateTemplate().find(hql);
    }

    /**
     * 执行带参的hql查询
     *
     * @param hql    hql语句
     * @param params 参数列表
     * @return List
     */
    public List find(String hql, Object... params) {
        return getHibernateTemplate().find(hql, params);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 获取session
     *
     * @return Session
     */
    public Session getSession() {
        return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }
}
