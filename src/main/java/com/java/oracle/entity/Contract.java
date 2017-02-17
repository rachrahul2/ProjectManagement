package com.java.oracle.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONTRACT")
public class Contract extends BaseEntity {
    @Column(name = "CONTRACT_CODE")
    private String contractCode;
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    @Column(name = "CONTRACT_DATE")
    @Temporal(TemporalType.DATE)
    private Date contractDate;
    @Column(name = "CONTRACT_VALUE")
    private Double contactValue;
    @Column(name = "REMAIN_VALUE")
    private Double remainValue;
    @Column (name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column (name = "DESCRIPTION")
    private String description;

    
    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Double getContactValue() {
        return contactValue;
    }

    public void setContactValue(Double contactValue) {
        this.contactValue = contactValue;
    }

    public Double getRemainValue() {
        return remainValue;
    }

    public void setRemainValue(Double remainValue) {
        this.remainValue = remainValue;
    }
    
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
