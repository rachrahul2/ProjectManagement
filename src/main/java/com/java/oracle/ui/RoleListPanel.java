package com.java.oracle.ui;

import com.java.oracle.dao.RoleDAO;
import com.java.oracle.entity.Role;
import com.java.oracle.ui.model.RoleTableModel;
import java.util.List;
import javax.swing.JDialog;

public class RoleListPanel extends DefaultListPanel<Role> {

    private final RoleDAO roleDAO = new RoleDAO(Role.class);
    
    public RoleListPanel(JDialog parent) {
        super(parent);
        loadDataList();
    }
    
    @Override
    public void loadDataList() {
        List<Role> roles = roleDAO.selectAll();
        RoleTableModel roleTableModel = new RoleTableModel();
        roleTableModel.addAll(roles);
        setTableModel(roleTableModel);
    }

    @Override
    public AbstractPanel buildEditPanel(Role bean) {
        if(bean != null) {
            RolePanel rolePanel = new RolePanel();
            rolePanel.setBean(bean);
            rolePanel.loadData();
            return rolePanel;
        }
        return null;
    }

    @Override
    public boolean deleteData(Role bean) {
        roleDAO.delete(bean.getId());
        return true;
    }
    
}
