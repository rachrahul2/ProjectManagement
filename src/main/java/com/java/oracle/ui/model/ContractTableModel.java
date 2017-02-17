package com.java.oracle.ui.model;

import com.java.oracle.dao.CustomerDAO;
import com.java.oracle.entity.Contract;
import com.java.oracle.entity.Customer;
import com.java.oracle.utils.DateUtils;

public class ContractTableModel extends AbstractTableModel<Contract> {

    private CustomerDAO customerDAO = new CustomerDAO(Customer.class);
    
    public ContractTableModel() {
        super(new String[] {"Contract Code", "Contract Date", "Customer", "Contract Value"});
    }
    
    @Override
    public String[] initRow(Contract bean) {
        Customer c = customerDAO.getById(bean.getCustomerId());
        String cusCode = c == null ? "" : c.getCustomerCode();
        String[] row = new String[] {bean.getContractCode(), DateUtils.parseFromDate(bean.getContractDate()), cusCode, bean.getContactValue() == null ? "" : bean.getContactValue().toString()};
        return row;
    }
    
}
