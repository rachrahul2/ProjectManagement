package com.java.oracle.ui.model;

import com.java.oracle.dao.ProjectContractDAO;
import com.java.oracle.entity.ProjectContract;
import com.java.oracle.vo.ProjectContractVO;

public class ProjectContractTableModel extends AbstractTableModel<ProjectContractVO> {

    private ProjectContractDAO projectContractDAO = new ProjectContractDAO(ProjectContract.class);
    
    public ProjectContractTableModel() {
        super(new String[] {"Contract Code", "Project Code", "Customer", "Contract Value", "Used Value"});
    }
    
    @Override
    public String[] initRow(ProjectContractVO bean) {
        String[] row = new String[] {bean.getContractCode(), bean.getProjectCode(), 
            bean.getCustomerCode(), bean.getContractValue(), bean.getUsedValue()};
        return row;
    }
    
}
