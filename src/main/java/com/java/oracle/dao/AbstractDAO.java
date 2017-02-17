package com.java.oracle.dao;

import com.java.oracle.utils.DatabaseUtil;
import java.util.List;
import org.hibernate.Session;

public class AbstractDAO <T> {

    private final Class<T> clzz;
    protected Session session;

    public AbstractDAO(Class<T> clzz) {
        this.clzz = clzz;
    }
    
    public T save(T bean) {
        if(bean != null) {
            session = getSession();
            session.getTransaction().begin();
            session.save(bean);
            session.getTransaction().commit();
            session.close();
            return bean;
        }
        return null;
    }
    
    public T update(T bean) {
        if(bean != null) {
            session = getSession();
            session.getTransaction().begin();
            session.update(bean);
            session.getTransaction().commit();
            session.close();
            return bean;
        }
        return null;
    }
    
    public boolean delete(Long id) {
        if(id != null && id > 0) {
            session = getSession();
            session.getTransaction().begin();
            session.delete(session.get(clzz, id));
            session.getTransaction().commit();
            session.close();
            return true;
        }
        return false;
    }
    
    public T getById(Long id) {
        session = getSession();
        T bean = (T) session.get(clzz, id);
        session.close();
        return bean;
    }
    
    public List<T> selectAll() {
        session = getSession();
        List list = session.createQuery("from " + clzz.getSimpleName() + " t").list();
        session.close();
        return list;
    }

    public Class<T> getClzz() {
        return clzz;
    }

    public Session getSession() {
        return DatabaseUtil.getCurrentSession();
    }
    
}
