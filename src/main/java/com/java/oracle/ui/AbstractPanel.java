package com.java.oracle.ui;

import com.java.oracle.dao.AbstractDAO;
import com.java.oracle.entity.BaseEntity;
import com.java.oracle.ui.event.BeforeSaveEvent;
import com.java.oracle.ui.event.SaveEvent;
import com.java.oracle.ui.event.SavedEventData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class AbstractPanel<T extends BaseEntity> extends JPanel {

    protected T bean;
    private List<SaveEvent> saveEvent;
    private BeforeSaveEvent beforeSaveEvent;
    private AbstractDAO<T> abstractDAO;

    public void setAbstractDAO(AbstractDAO<T> abstractDAO) {
        this.abstractDAO = abstractDAO;
    }

    public void setAfterSaveEvent(SaveEvent saveEvent) {
        if (this.saveEvent == null) {
            this.saveEvent = new ArrayList<>();
        }
        this.saveEvent.add(saveEvent);
    }

    public void setBeforeSaveEvent(BeforeSaveEvent beforeSaveEvent) {
        this.beforeSaveEvent = beforeSaveEvent;
    }

    void save() {
        if (bean != null) {
            if (bean.getId() != null && bean.getId() > 0) {
                if (validateData()) {
                    if (this.beforeSaveEvent != null) {
                        beforeSaveEvent.beforeSave();
                    }
                    bean = prepareData();
                    abstractDAO.update(bean);
                    if (saveEvent != null) {
                        SavedEventData data = new SavedEventData();
                        data.setData(bean);
                        data.setEdit(true);
                        for (SaveEvent event : saveEvent) {
                            event.afterSave(data);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Saved!");
                    bean = null;
                }
            }
        } else {
            if (validateData()) {
                bean = prepareData();
                if (this.beforeSaveEvent != null) {
                    beforeSaveEvent.beforeSave();
                }
                abstractDAO.save(bean);
                if (saveEvent != null) {
                    SavedEventData data = new SavedEventData();
                    data.setData(bean);
                    data.setEdit(false);
                    for (SaveEvent event : saveEvent) {
                        event.afterSave(data);
                    }
                }
                JOptionPane.showMessageDialog(null, "Saved!");
                bean = null;
            }
        }
    }

    public abstract T prepareData();

    public abstract boolean validateData();

    public void setBean(T bean) {
        this.bean = bean;
    }

    public abstract void loadData();

}
