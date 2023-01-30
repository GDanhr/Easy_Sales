package controller;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;

public class ControlProductStock {

    private String Qty = view.ViewMain.getProductsPane5TxtQty().getText().trim();
    private String search1 = view.ViewMain.getProductsPane5TxtProduct().getText().trim();
    private String search2 = view.ViewMain.getProductsTxtSearch().getText().trim();
    private JList list = view.ViewMain.getProductsPane5SearchList();
    private JComboBox cb = view.ViewMain.getProductsPane5CBoxProduct();
    private JTable table = view.ViewMain.getProductsPane5Table();
    private DB esql = new DB();

    public void loadProducts() {
        esql.loadProductStock(cb);
        view.ViewMain.setProductsPane5CBoxProduct(cb);
    }

    public void loadProductStockTable() {
        esql.loadProductStockTable(table);
        view.ViewMain.setProductsPane5Table(table);
    }

    public void btnSearchNum() {
        int code = Integer.parseInt(search2);
        esql.searchProductStockNum(code, table);
    }

    public void btnSearchName() {
        esql.searchProductStockList(search1, list);
    }

    public void mouseClickedList() {
        if (!list.isSelectionEmpty()) {
            String prod = list.getSelectedValue().toString();
            cb.setSelectedItem(prod);
            esql.searchProductStockName(prod, table);
        }
    }

    public void mouseClickedTable() {
        if (table.getSelectedRow() >= 0) {
            int row = table.getSelectedRow();
            String name = table.getValueAt(row, 2).toString();
            cb.setSelectedItem(name);
        }
    }

    public void btnAddStock() {
        if (table.getSelectedRow() >= 0) {
            if (!Qty.isBlank() && isNumeric(Qty)) {
                int numQty = Integer.parseInt(Qty);
                String str = "";
                int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                String items = esql.loadItemList(str, id);
                if (esql.checkStock(itemsList_Qty(items, numQty))) {
                    ControlProducts cp = new ControlProducts();
                    ControlProductsTable cpt = new ControlProductsTable();
                    ControlProductStock cps = new ControlProductStock();
                    esql.addProductStock(itemsList_Qty(items, numQty), id, numQty);
                    cpt.loadProductsTable();
                    cp.loadProductsTable();
                    cps.loadProducts();
                    loadProductStockTable();
                    JOptionPane.showMessageDialog(null, "Stock added");
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough items on stock", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the product in the table", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void btnReleaseStock() {
        if (table.getSelectedRow() >= 0) {
            if (!Qty.isBlank() && isNumeric(Qty)) {
                ControlProducts cp = new ControlProducts();
                ControlProductsTable cpt = new ControlProductsTable();
                ControlProductStock cps = new ControlProductStock();
                int numQty = Integer.parseInt(Qty);
                String str = "";
                int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                String items = esql.loadItemList(str, id);
                esql.releaseItems(itemsList_Qty(items, numQty));
                esql.updateStock(id, numQty);
                cpt.loadProductsTable();
                cp.loadProductsTable();
                cps.loadProducts();
                loadProductStockTable();
                JOptionPane.showMessageDialog(null, "Items released");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the product in the table", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void Clear() {
        view.ViewMain.getProductsPane5TxtQty().setText("");
        DefaultListModel nm = new DefaultListModel();
        list.setModel(nm);
        cb.setSelectedIndex(0);
        loadProductStockTable();
        view.ViewMain.getProductsPane5TxtProduct().setText("");
        view.ViewMain.getProductsTxtSearch().setText("");
    }

    private ArrayList itemsList_Qty(String itemList, int qty) {
        ArrayList iList = new ArrayList();
        int item_qty = 0;
        int total_qty = 0;
        String item = "";
        for (int i = itemList.length(); i > 0; i--) {
            if (itemList.charAt(i - 1) == 'X') {
                item_qty = Integer.parseInt(itemList.substring(i));
                total_qty = item_qty * qty;
                iList.add(total_qty);
                itemList = itemList.substring(0, i - 2);
                i = itemList.length();
            } else if (itemList.charAt(i - 1) == ';') {
                item = itemList.substring(i);
                iList.add(item);
                itemList = itemList.substring(0, i - 1);
                i = itemList.length();
            } else if (i == 1) {
                iList.add(itemList);
            }
        }
        return iList;
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
