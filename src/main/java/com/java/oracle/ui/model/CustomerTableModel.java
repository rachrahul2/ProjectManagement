package com.java.oracle.ui.model;

import com.java.oracle.entity.Customer;

public class CustomerTableModel extends AbstractTableModel<Customer> {

    public CustomerTableModel() {
        super(new String[] {"Customer Code", "Customer Name", "Description"});
    }
    
    @Override
    public String[] initRow(Customer bean) {
        String[] row = new String[] {bean.getCustomerCode(), bean.getCustomerName(), bean.getDescription()};
        return row;
    }
    
}
