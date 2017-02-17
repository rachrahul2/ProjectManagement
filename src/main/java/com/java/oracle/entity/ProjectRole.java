package com.java.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_ROLE")
public class ProjectRole extends BaseEntity {
    @Column (name = "PROJECT_ID")
    private Long projectId;
    @Column (name = "ROLE_ID")
    private Long roleId;
    @Column (name = "Employee")
    private String employee;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
    
}
