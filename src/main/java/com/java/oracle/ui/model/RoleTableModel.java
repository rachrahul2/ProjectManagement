package com.java.oracle.ui.model;

import com.java.oracle.entity.Role;

public class RoleTableModel extends AbstractTableModel<Role> {

    public RoleTableModel() {
        super(new String[] {"Role Code", "Role Name", "Active"});
    }

    @Override
    public String[] initRow(Role bean) {
        String[] row = new String[]{bean.getRoleCode(), bean.getRoleName()};
        return row;
    }
    
}
