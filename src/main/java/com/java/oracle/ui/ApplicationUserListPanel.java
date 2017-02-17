package com.java.oracle.ui;

import com.java.oracle.dao.ApplicationUserDAO;
import com.java.oracle.entity.ApplicationUser;
import com.java.oracle.ui.model.ApplicationUserTableModel;
import java.util.List;
import javax.swing.JDialog;

public class ApplicationUserListPanel extends DefaultListPanel<ApplicationUser> {

    private final ApplicationUserDAO applicationUserDAO = new ApplicationUserDAO(ApplicationUser.class);
    
    public ApplicationUserListPanel(JDialog parent) {
        super(parent);
        loadDataList();
    }
    
    @Override
    public void loadDataList() {
        List<ApplicationUser> applicationUsers = applicationUserDAO.selectAll();
        ApplicationUserTableModel applicationUserTableModel = new ApplicationUserTableModel();
        applicationUserTableModel.addAll(applicationUsers);
        setTableModel(applicationUserTableModel);
    }

    @Override
    public AbstractPanel buildEditPanel(ApplicationUser bean) {
        if(bean != null) {
            UserPanel userPanel = new UserPanel();
            userPanel.setBean(bean);
            userPanel.loadData();
            return userPanel;
        }
        return null;
    }

    @Override
    public boolean deleteData(ApplicationUser bean) {
        applicationUserDAO.delete(bean.getId());
        return true;
    }
    
}
