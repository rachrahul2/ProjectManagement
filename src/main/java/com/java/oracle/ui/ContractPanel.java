package com.java.oracle.ui;

import com.java.oracle.dao.ContractDAO;
import com.java.oracle.dao.CustomerDAO;
import com.java.oracle.entity.Contract;
import com.java.oracle.entity.Customer;
import com.java.oracle.utils.DateUtils;
import com.java.oracle.vo.ComboItem;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ContractPanel extends AbstractPanel<Contract> {

    private ContractDAO contractDAO;
    private CustomerDAO customerDAO;

    private DefaultComboBoxModel cboCustomerModel;

    /**
     * Creates new form ContractPanel
     */
    public ContractPanel() {
        contractDAO = new ContractDAO(Contract.class);
        customerDAO = new CustomerDAO(Customer.class);
        setAbstractDAO(contractDAO);
        initComponents();
        cboCustomerModel = new DefaultComboBoxModel();
        cboCustomer.setModel(cboCustomerModel);
        initCombobox();
    }

    @Override
    public Contract prepareData() {
        if (bean == null) {
            bean = new Contract();
        }
        bean.setContractCode(txtContractCode.getText());
        bean.setCustomerId(((ComboItem) cboCustomer.getSelectedItem()).getId());
        bean.setContractDate(DateUtils.parseFromString(txtContractDate.getText()));
        bean.setEndDate(DateUtils.parseFromString(txtEndDate.getText()));
        bean.setContactValue(Double.parseDouble(txtValue.getText()));
        bean.setRemainValue(Double.parseDouble(txtValue.getText()));
        return bean;
    }

    @Override
    public boolean validateData() {
        if (txtContractCode.getText() == null || txtContractCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contract code is mandatory!");
            txtContractCode.requestFocus();
            return false;
        }
        if (cboCustomer.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Customer is mandatory!");
            return false;
        }
        if (txtContractDate.getText() == null || txtContractDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contract date is mandatory!");
            txtContractDate.requestFocus();
            return false;
        }

        if (txtEndDate.getText() == null || txtEndDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contract end date is mandatory!");
            txtEndDate.requestFocus();
            return false;
        }

        if (txtValue.getText() == null || txtValue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contract value is mandatory!");
            txtValue.requestFocus();
            return false;
        }
        
        if (txtContractDate.getText() != null || !txtContractDate.getText().isEmpty()) {
            if (DateUtils.parseFromString(txtContractDate.getText()) == null) {
                txtContractDate.requestFocus();
                return false;
            }
        }
        if (txtEndDate.getText() != null || !txtEndDate.getText().isEmpty()) {
            if (DateUtils.parseFromString(txtEndDate.getText()) == null) {
                txtEndDate.requestFocus();
                return false;
            }
        }
        
        if(txtValue.getText() != null) {
            try {
                Double.parseDouble(txtValue.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Value must be number format!");
                txtValue.requestFocus();
            }
        }
        
        return true;
    }

    @Override
    public void loadData() {
        if(bean != null) {
            txtContractCode.setText(bean.getContractCode());
            txtContractDate.setText(DateUtils.parseFromDate(bean.getContractDate()));
            txtEndDate.setText(DateUtils.parseFromDate(bean.getEndDate()));
            txtDescription.setText(bean.getDescription());
            if (bean.getCustomerId() != null) {
                Customer c = customerDAO.getById(bean.getCustomerId());
                if (c != null) {
                    for(int i = 0; i < cboCustomerModel.getSize(); i++) {
                        if(c.getId().equals(((ComboItem)cboCustomerModel.getElementAt(i)).getId())) {
                            cboCustomer.setSelectedIndex(i);
                            break;
                        }
                    }
                }
            }
            if(bean.getContactValue() != null) {
                txtValue.setText(bean.getContactValue().toString());
            }
        }
    }

    private void initCombobox() {
        List<Customer> customers = customerDAO.selectAll();
        if (customers != null && !customers.isEmpty()) {
            for (Customer c : customers) {
                cboCustomerModel.addElement(new ComboItem(c.getId(), c.getCustomerCode()));
            }
        }
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtContractCode = new javax.swing.JTextField();
        cboCustomer = new javax.swing.JComboBox<>();
        txtContractDate = new javax.swing.JTextField();
        txtValue = new javax.swing.JTextField();
        txtEndDate = new javax.swing.JTextField();
        scrollDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTRACT");

        jLabel2.setText("Contract Code");

        jLabel3.setText("Customer");

        jLabel4.setText("Contract Date");

        jLabel5.setText("Value");

        jLabel6.setText("End Date");

        jLabel7.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        scrollDescription.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtContractCode))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cboCustomer, 0, 295, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValue, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                    .addComponent(scrollDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtContractDate, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContractCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContractDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(scrollDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane scrollDescription;
    private javax.swing.JTextField txtContractCode;
    private javax.swing.JTextField txtContractDate;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
