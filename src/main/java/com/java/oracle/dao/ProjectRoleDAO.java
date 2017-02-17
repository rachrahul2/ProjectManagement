package com.java.oracle.dao;

import com.java.oracle.entity.ApplicationUser;
import com.java.oracle.entity.ProjectRole;
import com.java.oracle.vo.ProjectRoleVO;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

public class ProjectRoleDAO extends AbstractDAO<ProjectRole> {

    public ProjectRoleDAO(Class<ProjectRole> clzz) {
        super(ProjectRole.class);
    }

    public List<ProjectRoleVO> getProjectRole(ApplicationUser applicationUser) {
        session = getSession();
        String sql = "select pr.id as \"id\", p.project_code as \"projectCode\", pr.employee as \"employee\", r.role_code as \"roleCode\"\n"
                + " from project p \n"
                + " join project_role pr\n"
                + " on p.id = pr.project_id\n"
                + " join app_role r\n"
                + " on pr.role_id = r.id"
                + " join application_user u\n"
                + " on pr.employee = u.account\n"
                + " where 1=1 ";
        if (applicationUser != null) {
            if (!applicationUser.isAdmin()) {
                sql += " and u.account=:account";
            }
            SQLQuery query = session.createSQLQuery(sql);
            if (!applicationUser.isAdmin()) {
                query.setString("account", applicationUser.getAccount());
            }
            query.addScalar("id", StandardBasicTypes.LONG)
                    .addScalar("projectCode", StandardBasicTypes.STRING)
                    .addScalar("roleCode", StandardBasicTypes.STRING)
                    .addScalar("employee", StandardBasicTypes.STRING)
                    .setResultTransformer(Transformers.aliasToBean(ProjectRoleVO.class));
            List list = query.list();
            session.close();
            return list;
        }

        return null;
    }
    
    public int checkProjectRole(Long pId, String employee, Long roleId) {
        session = getSession();
        String sql = "select count(1) from project_role pr"
                + " where pr.project_id=:pid and pr.employee=:employee"
                + " and pr.role_id=:roleId";
        SQLQuery query = session.createSQLQuery(sql);
        query.setLong("pid", pId);
        query.setString("employee", employee);
        query.setLong("roleId", roleId);
        int count = ((BigDecimal)query.uniqueResult()).intValue();
        return count;
    }
}
