package com.java.oracle.main;

import com.java.oracle.dao.ProjectDAO;
import com.java.oracle.dao.RoleDAO;
import com.java.oracle.entity.Project;
import com.java.oracle.entity.Role;
import com.java.oracle.utils.DatabaseUtil;


public class Main {

    public static void main(String[] args) {
        Project p = new Project();
        p.setCustomerId(2L);
        p.setProjectCode("B");
        ProjectDAO projectDAO = new ProjectDAO(Project.class);
        projectDAO.save(p);
        System.out.println("Saved! " + p.getId());
        
        Role r = new Role();
        r.setActive(true);
        r.setRoleCode("B");
        r.setRoleName("Name");
        RoleDAO roleDAO = new RoleDAO(Role.class);
        roleDAO.save(r);
        System.out.println("Saved role!" + r.getId());
        
        DatabaseUtil.shutdown();
    }
}
