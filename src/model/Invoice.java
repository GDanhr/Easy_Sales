
package model;

import javax.swing.JTable;

public class Invoice {
    private String date;
    private String total;
    private JTable table;
    private String discount;

    public Invoice() {
    }

    public Invoice(String date, String total, JTable table, String discount) {
        this.date = date;
        this.total = total;
        this.table = table;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Invoice{" + "date=" + date + ", total=" + total + ", table=" + table + ", discount=" + discount + '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    
}
