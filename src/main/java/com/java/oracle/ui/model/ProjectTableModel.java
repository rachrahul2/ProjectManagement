package com.java.oracle.ui.model;

import com.java.oracle.entity.Project;

public class ProjectTableModel extends AbstractTableModel<Project> {

    public ProjectTableModel() {
        super(new String[] {"Project Code", "Project Name", "Leader", "Status"});
    }

    @Override
    public String[] initRow(Project bean) {
        String[] row = new String[] {bean.getProjectCode(), bean.getProjectName(), bean.getProjectLead(), bean.getStatus()};
        return row;
    }

}
