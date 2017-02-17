package com.java.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION_USER")
public class ApplicationUser extends BaseEntity {
    
    public static final String ROLE_PROJECT_ADMIN = "Project Admin";
    public static final String ROLE_PROJECT_MEMBER = "Project Member";
    public static final String ROLE_REPORTER = "Reporter";
    
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "NAME")
    private String name;
    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "ACTIVE")
    private Boolean active;
    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "IS_ADMIN")
    private Boolean admin;
    @Column(name = "ROLE_CODE")
    private String roleCode;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PASSWORD")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
