package controller;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;
import model.ProductLine;
import controller.ControlProducts;

public class ControlProductLine {
    
    private String name = view.ViewMain.getProductsPane3TxtProductLineName().getText().trim();
    private JTable table = view.ViewMain.getProductsPane3Table();
    private DB esql = new DB();
    private ProductLine pl = new ProductLine();
    private ControlProducts cp = new ControlProducts();
    
    public boolean addLine() {
        if (!name.isEmpty() && esql.newLine(name)) {
            pl.setProductLine_Name(name);
            esql.addLine(pl);
            JOptionPane.showMessageDialog(null, "Product line added");
            cp.loadLines();
            Clear();
            loadProductLines();
            
            return true;
        }
        return false;
    }
    
    public void saveLine()  {
        int columns = table.getColumnCount();//ESTO SE PUEDE CAMBIAR POR UN GETSELECTEDROW 
        for (int i = 0; i < columns; i++) {
            if (table.isColumnSelected(i)) {
                pl.setProductLine_Name(name);
                int row = table.getSelectedRow();
                String newName = table.getValueAt(row, 1).toString();
                if (esql.updateLine(pl, newName)) {
                    JOptionPane.showMessageDialog(null, "Changes saved");
                    cp.loadLines();
                    Clear();
                    loadProductLines();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select the product line in the table");
            }
        }
    }
    
    public void mouseClickedItemsTable() {
        try {
            int row = table.getSelectedRow();
            String namec = table.getValueAt(row, 1).toString();
            view.ViewMain.setProductsPane3TxtProductLineName(namec);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void deleteLine() {
        String ask = "Are you sure you want to delete " + name + " from your productlines?";
        int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            esql.removeLine(name);
            cp.loadLines();
            Clear();
            loadProductLines();
        }
    }
    
    public void searchLine()  {
        String searchText = view.ViewMain.getProductsTxtSearch().getText().trim();
        if (!searchText.isEmpty()) {
            if (isNumeric(searchText) && esql.searchProductLineTable(table, Integer.parseInt(searchText))) {
                esql.searchProductLineTable(table, searchText);
            } else if (!isNumeric(searchText)) {
                esql.searchProductLineTable(table, searchText);
            }
            Clear();
        }
    }
    
    public void loadProductLines() {
        esql.productLineTable(table);
        view.ViewMain.setProductsPane3Table(table);
    }
    
    public void Clear() {
        view.ViewMain.setProductsPane3TxtProductLineName("");
        view.ViewMain.setProductsTxtSearch("");
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
