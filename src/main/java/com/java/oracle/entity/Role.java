package com.java.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ROLE")
public class Role extends BaseEntity {
    
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "ACTIVE")
    private boolean active;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
}
