package controller;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.DB;

public class ControlProductsTable {
    private DB esql = new DB();
    private JTable table = new JTable();
    private String searchText = view.ViewMain.getProductsTxtSearch().getText().trim();
    
    public void loadProductsTable()  {
        JScrollPane sp = view.ViewMain.getjScrollPane11();
        sp.setViewportView(esql.productsTable());
        view.ViewMain.setjScrollPane11(sp);
    }
    
    public void searchLine()  {
        if (!searchText.isEmpty() && isNumeric(searchText)) {
            int id_code = Integer.parseInt(searchText);
            JScrollPane sp = view.ViewMain.getjScrollPane11();
            if (esql.searchProductsTableById(id_code)) {
                table = esql.searchProductsTable("id", id_code);
                sp.setViewportView(table);
                view.ViewMain.setjScrollPane11(sp);
            } else if (esql.searchProductsTableByCode(id_code)) {
                table = esql.searchProductsTable("code", id_code);
                sp.setViewportView(table);
                view.ViewMain.setjScrollPane11(sp);
            } else {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            loadProductsTable();
        }
    }
    private boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
