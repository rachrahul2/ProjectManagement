package com.java.oracle.ui.model;

import com.java.oracle.entity.ApplicationUser;

public class ApplicationUserTableModel extends AbstractTableModel<ApplicationUser> {

    public ApplicationUserTableModel() {
        super(new String[] {"User Name", "Full Name"});
    }

    @Override
    public String[] initRow(ApplicationUser bean) {
        String[] row = new String[]{bean.getAccount(), bean.getName()};
        return row;
    }
    
}
