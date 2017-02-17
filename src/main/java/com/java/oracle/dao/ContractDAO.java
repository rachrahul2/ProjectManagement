package com.java.oracle.dao;

import com.java.oracle.entity.Contract;

public class ContractDAO extends AbstractDAO<Contract> {

    public ContractDAO(Class<Contract> clzz) {
        super(Contract.class);
    }
}
