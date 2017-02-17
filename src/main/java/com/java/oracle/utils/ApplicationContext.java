package com.java.oracle.utils;

import com.java.oracle.entity.ApplicationUser;

public class ApplicationContext {

    private static ApplicationUser applicationUser;
    
    public static void setLoggedinUser(ApplicationUser user) {
        applicationUser = user;
    }
    
    public static ApplicationUser getLoggedinUser() {
        return applicationUser;
    }
}
