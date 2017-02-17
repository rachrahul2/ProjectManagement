package com.java.oracle.dao;

import com.java.oracle.entity.ProjectContract;
import com.java.oracle.vo.ProjectContractVO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

public class ProjectContractDAO extends AbstractDAO<ProjectContract> {

    public ProjectContractDAO(Class<ProjectContract> clzz) {
        super(ProjectContract.class);
    }

    public List<ProjectContractVO> getAllProjectContract() {
        String sql = "select pc.id as\"id\", p.project_code as \"projectCode\", \n"
                + "ct.customer_code as \"customerCode\",\n"
                + "c.contract_code as \"contractCode\",\n"
                + "c.contract_value as \"contractValue\",\n"
                + "pc.used_value as \"usedValue\"\n"
                + "from project_contract pc\n"
                + "join project p\n"
                + "on pc.project_id = p.id\n"
                + "join contract c\n"
                + "on pc.contract_id = c.id\n"
                + "join customer ct\n"
                + "on c.customer_id = ct.id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addScalar("projectCode", StandardBasicTypes.STRING)
                .addScalar("customerCode", StandardBasicTypes.STRING)
                .addScalar("id", StandardBasicTypes.LONG)
                .addScalar("contractCode", StandardBasicTypes.STRING)
                .addScalar("contractValue", StandardBasicTypes.STRING)
                .addScalar("usedValue", StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(ProjectContractVO.class));
        return query.list();
    }
    
    public int checkContract(Long projectId) {
        String sql = "select count(1) from project_contract pc "
                + "where pc.project_id = :projectId";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setLong("projectId", projectId);
        BigDecimal res = (BigDecimal) query.uniqueResult();
        return res.intValue();
    }
}
