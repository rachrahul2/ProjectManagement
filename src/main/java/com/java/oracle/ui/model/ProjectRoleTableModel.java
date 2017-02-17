package com.java.oracle.ui.model;

import com.java.oracle.vo.ProjectRoleVO;

public class ProjectRoleTableModel extends AbstractTableModel<ProjectRoleVO> {

    public ProjectRoleTableModel() {
        super(new String[] {"ID", "Project Code", "Employee", "Role Code"});
    }

    @Override
    public String[] initRow(ProjectRoleVO bean) {
        String[] row = new String[]{bean.getId().toString(), bean.getProjectCode(), bean.getEmployee(), bean.getRoleCode()};
        return row;
    }
    
}
