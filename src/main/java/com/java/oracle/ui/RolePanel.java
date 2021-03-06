/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.oracle.ui;

import com.java.oracle.dao.RoleDAO;
import com.java.oracle.entity.Role;
import javax.swing.JOptionPane;

/**
 *
 * @author VinhLV
 */
public class RolePanel extends AbstractPanel<Role> {

    private RoleDAO roleDAO;
    
    /**
     * Creates new form RolePanel
     */
    public RolePanel() {
        roleDAO = new RoleDAO(Role.class);
        setAbstractDAO(roleDAO);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ckbActive = new javax.swing.JCheckBox();
        txtRoleCode = new javax.swing.JTextField();
        txtRoleName = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ROLE");

        jLabel2.setText("Role Code");

        jLabel3.setText("Role Name");

        ckbActive.setText("Active");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ckbActive, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 217, Short.MAX_VALUE))
                    .addComponent(txtRoleName)
                    .addComponent(txtRoleCode))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRoleCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ckbActive)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Role prepareData() {
        if(bean == null) {
            bean = new Role();
        }
        bean.setRoleCode(txtRoleCode.getText());
        bean.setRoleName(txtRoleName.getText());
        bean.setActive(ckbActive.isSelected());
        return bean;
    }

    @Override
    public boolean validateData() {
        if(txtRoleCode.getText() == null || txtRoleCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Role code is mandatory!");
            txtRoleCode.requestFocus();
            return false;
        }
        if(txtRoleName.getText() == null || txtRoleName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Role name is mandatory!");
            txtRoleName.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void loadData() {
        if(bean != null) {
            txtRoleCode.setText(bean.getRoleCode());
            txtRoleName.setText(bean.getRoleName());
            ckbActive.setSelected(bean.isActive());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ckbActive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtRoleCode;
    private javax.swing.JTextField txtRoleName;
    // End of variables declaration//GEN-END:variables
}
