package com.java.oracle.ui.event;

public interface SaveEvent<T> {

    public void afterSave(SavedEventData evt);
}
