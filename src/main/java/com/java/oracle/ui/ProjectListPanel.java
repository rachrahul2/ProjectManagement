package com.java.oracle.ui;

import com.java.oracle.ui.model.ProjectTableModel;
import com.java.oracle.dao.ProjectDAO;
import com.java.oracle.entity.Project;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ProjectListPanel extends DefaultListPanel<Project> {

    private final ProjectDAO projectDAO = new ProjectDAO(Project.class);
    public ProjectListPanel(JDialog parent) {
        super(parent);
        loadDataList();
    }    
    
    @Override
    public void loadDataList() {
        List<Project> projects = projectDAO.selectAll();
        ProjectTableModel model = new ProjectTableModel();
        model.addAll(projects);
        setTableModel(model);
    }

    @Override
    public AbstractPanel buildEditPanel(Project bean) {
        if(bean != null) {
            ProjectPanel panel = new ProjectPanel();
            panel.setBean(bean);
            panel.loadData();
            return panel;
        }
        return null;
    }

    @Override
    public boolean deleteData(Project bean) {
        if(bean.getStatus().equals("Open") || bean.getStatus().equals("Cancel")) {
            projectDAO.delete(bean.getId());
        } else {
            JOptionPane.showMessageDialog(null, "This project in use, so you cannot delete it!");
            return false;
        }
        return true;
    }

}
