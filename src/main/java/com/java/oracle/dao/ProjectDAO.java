package com.java.oracle.dao;

import com.java.oracle.entity.Project;

public class ProjectDAO extends AbstractDAO<Project> {

    public ProjectDAO(Class<Project> clzz) {
        super(Project.class);
    }

}
