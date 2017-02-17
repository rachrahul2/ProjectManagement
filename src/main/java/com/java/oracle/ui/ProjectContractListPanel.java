package com.java.oracle.ui;

import com.java.oracle.dao.ContractDAO;
import com.java.oracle.dao.ProjectContractDAO;
import com.java.oracle.entity.Contract;
import com.java.oracle.entity.ProjectContract;
import com.java.oracle.ui.model.ProjectContractTableModel;
import com.java.oracle.vo.ProjectContractVO;
import java.util.List;
import javax.swing.JDialog;

public class ProjectContractListPanel extends DefaultListPanel<ProjectContractVO> {

    private final ProjectContractDAO projectContractDAO = new ProjectContractDAO(ProjectContract.class);
    private final ContractDAO contractDAO = new ContractDAO(Contract.class);

    public ProjectContractListPanel(JDialog parent) {
        super(parent);
        loadDataList();
    }

    @Override
    public void loadDataList() {
        List<ProjectContractVO> projects = projectContractDAO.getAllProjectContract();
        ProjectContractTableModel model = new ProjectContractTableModel();
        model.addAll(projects);
        setTableModel(model);
    }

    @Override
    public AbstractPanel buildEditPanel(ProjectContractVO bean) {
        if (bean != null) {
            ProjectContract contract = projectContractDAO.getById(bean.getId());
            ProjectContractPanel panel = new ProjectContractPanel();
            panel.setBean(contract);
            panel.loadData();
            return panel;
        }
        return null;
    }

    @Override
    public boolean deleteData(ProjectContractVO bean) {
        // Update remain value
        ProjectContract projectContract = projectContractDAO.getById(bean.getId());
        Contract contract = contractDAO.getById(projectContract.getContractId());
        if (contract != null) {
            contract.setRemainValue(contract.getRemainValue() + projectContract.getUsedValue());
            contractDAO.update(contract);
        }
        projectContractDAO.delete(bean.getId());
        return true;
    }

}
