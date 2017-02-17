package com.java.oracle.utils;

import com.java.oracle.ui.SelectProjectDialog;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportUtil {

    public enum ReportType {
        PROJECT, PROJECT_CONTRACT, PROJECT_MEMBER,
        REV_CUSTOMER, REV_PROJECT,
        CONTRACT_REMAIN
    }

    public static void viewReport(ReportType reportType) {
        switch (reportType) {
            case PROJECT:
                loadReport("report_project.jrxml", null);
                break;
            case PROJECT_CONTRACT:
                loadReport("customer_project.jrxml", null);
                break;
            case PROJECT_MEMBER:
                SelectProjectDialog dialog = new SelectProjectDialog((id) -> {
                    Map parameters = new HashMap();
                    parameters.put("id", id);
                    loadReport("project_member.jrxml", parameters);
                });
                dialog.setVisible(true);
                break;
            case REV_CUSTOMER:
                loadReport("revenue_by_customer.jrxml", null);
                break;
            case REV_PROJECT:
                loadReport("project_top_rev.jrxml", null);
                break;
            case CONTRACT_REMAIN:
                loadReport("contract_remain.jrxml", null);
                break;
        }
    }

//    public static void main(String[] args) {
//        viewReport(ReportType.PROJECT_CONTRACT);
//    }
    
    private static void loadReport(String reportFile, Map parameters) {
        try {
            String reportSource = reportFile; //report folder is in WebPages folder
            JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DatabaseUtil.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
    }
}
