package com.java.oracle.ui;

import com.java.oracle.dao.ContractDAO;
import com.java.oracle.entity.Contract;
import com.java.oracle.ui.model.ContractTableModel;
import java.util.List;
import javax.swing.JDialog;

public class ContractListPanel extends DefaultListPanel<Contract> {

    private final ContractDAO contractDAO = new ContractDAO(Contract.class);
    
    public ContractListPanel(JDialog parent) {
        super(parent);
        loadDataList();
    }
    
    @Override
    public void loadDataList() {
        List<Contract> contracts = contractDAO.selectAll();
        ContractTableModel contractTableModel = new ContractTableModel();
        contractTableModel.addAll(contracts);
        setTableModel(contractTableModel);
    }

    @Override
    public AbstractPanel buildEditPanel(Contract bean) {
          if(bean != null) {
            ContractPanel panel = new ContractPanel();
            panel.setBean(bean);
            panel.loadData();
            return panel;
        }
        return null;
    }

    @Override
    public boolean deleteData(Contract bean) {
        contractDAO.delete(bean.getId());
        return true;
    }
    
}
