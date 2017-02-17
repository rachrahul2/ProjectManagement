package com.java.oracle.ui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractTableModel<T> extends DefaultTableModel {

    private List<T> beans;
    
    public AbstractTableModel(String[] header) {
        super(header, 0);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    
    public void addData(T bean) {
        String[] row = initRow(bean);
        addRow(row);
        if(beans == null) {
            beans = new ArrayList<>();
            beans.add(bean);
        }
        fireTableDataChanged();
    }
    
    public T getData(int row) {
        if(row < getRowCount()) {
            return beans.get(row);
        }
        return null;
    }
    
    public void addAll(List<T> list) {
        for(T t:list) {
            String[] r = initRow(t);
            addRow(r);
        }
        if(beans == null) {
            beans = new ArrayList<>();
        }
        beans.addAll(list);
        fireTableDataChanged();
    }
    
    public abstract String[] initRow(T bean);
}
