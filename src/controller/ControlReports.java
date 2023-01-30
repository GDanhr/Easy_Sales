package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import model.DB;

public class ControlReports {
    private String saleOrPurchase = view.ViewMain.getReportsPurchasesOrSales().getSelectedItem().toString();
    private JTable table = view.ViewMain.getReportsTable();
    private DB esql = new DB();

    public void loadReportsTable() {
        esql.loadReportsSalesTable(table);
    }

    public void search() {
        if (saleOrPurchase.equals("Sales")) {
            if (view.ViewMain.getReportsFromDate().getDate() != null) {
                if (view.ViewMain.getReportsToDate().getDate() != null) {
                    /*if there is FROM and TO date*/
                    Date from = view.ViewMain.getReportsFromDate().getDate();
                    Date to = view.ViewMain.getReportsToDate().getDate();
                    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                    esql.loadReportsSalesTable(table, format.format(from), lastDigit(format.format(to)));
                }else{
                    /*if there is only FROM date*/
                    Date date = view.ViewMain.getReportsFromDate().getDate();
                    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                    esql.loadReportsSalesTable(table, format.format(date));
                }
            } else {
                /*if there is only Sales*/
                esql.loadReportsSalesTable(table);
            }
        } else {
            if (view.ViewMain.getReportsFromDate().getDate() != null) {
                if (view.ViewMain.getReportsToDate().getDate() != null) {
                    /*if there is FROM and TO date*/
                    Date from = view.ViewMain.getReportsFromDate().getDate();
                    Date to = view.ViewMain.getReportsToDate().getDate();
                    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                    esql.loadReportsPurchasesTable(table, format.format(from), lastDigit(format.format(to)));
                } else {
                    /*if there is only FROM date*/
                    Date date = view.ViewMain.getReportsFromDate().getDate();
                    SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                    esql.loadReportsPurchasesTable(table, format.format(date));
                }
            } else {
                /*if there is only Purchases*/
                esql.loadReportsPurchasesTable(table);
            }
        }
    }
    
    private String lastDigit(String date){
        int last = Integer.parseInt(date.substring(date.length()-2)) + 1;
        if(last>31){last=31;}
        date = date.substring(0,date.length()-2) + last;
        return date;
    }
    
    public void clear(){
        view.ViewMain.getReportsFromDate().setCalendar(null);
        view.ViewMain.getReportsToDate().setCalendar(null);
        loadReportsTable();
    }
}
