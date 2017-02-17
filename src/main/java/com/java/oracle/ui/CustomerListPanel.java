package com.java.oracle.ui;

import com.java.oracle.dao.CustomerDAO;
import com.java.oracle.entity.Customer;
import com.java.oracle.ui.model.CustomerTableModel;
import java.util.List;
import javax.swing.JDialog;

public class CustomerListPanel extends DefaultListPanel<Customer> {

    private final CustomerDAO customerDAO = new CustomerDAO(Customer.class);
    
    public CustomerListPanel(JDialog parent) {
        super(parent);
        loadDataList();
    }
    
    @Override
    public void loadDataList() {
        List<Customer> customers = customerDAO.selectAll();
        CustomerTableModel customerTableModel = new CustomerTableModel();
        customerTableModel.addAll(customers);
        setTableModel(customerTableModel);
    }

    @Override
    public AbstractPanel buildEditPanel(Customer bean) {
          if(bean != null) {
            CustomerPanel panel = new CustomerPanel();
            panel.setBean(bean);
            panel.loadData();
            return panel;
        }
        return null;
    }

    @Override
    public boolean deleteData(Customer bean) {
        customerDAO.delete(bean.getId());
        return true;
    }
    
}
