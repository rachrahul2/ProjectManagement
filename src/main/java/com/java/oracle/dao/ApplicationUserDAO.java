package com.java.oracle.dao;

import com.java.oracle.entity.ApplicationUser;
import org.hibernate.Query;

public class ApplicationUserDAO extends AbstractDAO<ApplicationUser> {
    
    public ApplicationUserDAO(Class<ApplicationUser> clzz) {
        super(ApplicationUser.class);
    }
    
    public ApplicationUser getByCode(String code) {
        session = getSession();
        Query query = session.createQuery("from " + getClzz().getSimpleName() + " t"
                + " where t.account=:lead");
        query.setString("lead", code);
        ApplicationUser user = (ApplicationUser) query.uniqueResult();
        session.close();
        return user;
    }
    
    public ApplicationUser getByUserNamePassword(String userName, String password) {
        session = getSession();
        Query query = getSession().createQuery("from " + getClzz().getSimpleName() + " t"
                + " where t.account=:account and t.password=:password");
        query.setString("account", userName);
        query.setString("password", password);
        ApplicationUser user = (ApplicationUser) query.uniqueResult();
        session.close();
        return user;
    }
}
