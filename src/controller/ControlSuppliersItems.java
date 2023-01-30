package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;
import model.PurchaseItem;

public class ControlSuppliersItems {

    private String Qty = view.ViewMain.getSuppliersPane2TxtQuantity().getText().trim();
    private String totalCost = view.ViewMain.getSuppliersPane2TxtTotalCost().getText().trim();
    private String supplier = view.ViewMain.getSuppliersPane2SupplierList().getSelectedItem().toString();
    private String item = view.ViewMain.getSuppliersPane2ItemList().getSelectedItem().toString();
    private JComboBox itemList = view.ViewMain.getSuppliersPane2ItemList();
    private JComboBox supplierList = view.ViewMain.getSuppliersPane2SupplierList();
    private boolean noItemSelected = 0 > view.ViewMain.getSuppliersPane2ItemList().getSelectedIndex();
    private JTable table = view.ViewMain.getSuppliersPane2Table();
    private DB esql = new DB();
    private PurchaseItem pi = new PurchaseItem();
    private ControlProducts cp = new ControlProducts();

    public byte addPurchaseItems() {
        if (Qty.isEmpty() && totalCost.isEmpty() && supplier.equals("--") && item.equals("--")) {
            // Ignore
            return 1;
        } else if (item.equals("--")) {
            if (itemList.getItemCount() == 1) {
                JOptionPane.showMessageDialog(null, "You need an item, create one", "Error", JOptionPane.PLAIN_MESSAGE);
                //ENVIAR A PRODUCTS ITEM PARA CREAR UNO
                return 2;
            } else {
                JOptionPane.showMessageDialog(null, "Select item", "Error", JOptionPane.PLAIN_MESSAGE);
                return 3;
            }

        } else if (supplier.equals("--")) {
            if (supplierList.getItemCount() == 1) {
                JOptionPane.showMessageDialog(null, "You need a supplier, register one, create one", "Error", JOptionPane.PLAIN_MESSAGE);
                //ENVIAR A SUPPLIERS PARA CREAR UNO
                return 4;
            } else {
                JOptionPane.showMessageDialog(null, "Select supplier", "Error", JOptionPane.PLAIN_MESSAGE);
                return 5;
            }
        } else if (Qty.isEmpty() || !isNumeric(Qty)) {
            JOptionPane.showMessageDialog(null, "Insert a valid number", "Error", JOptionPane.PLAIN_MESSAGE);
            return 6;
        } else if (totalCost.isEmpty() || !isFloat(totalCost)) {
            JOptionPane.showMessageDialog(null, "Insert a valid price", "Error", JOptionPane.PLAIN_MESSAGE);
            return 7;
        } else if (supplier.equals("--")) {
            JOptionPane.showMessageDialog(null, "Insert the supplier", "Error", JOptionPane.PLAIN_MESSAGE);
            return 8;
        } else if (!(noItemSelected && Qty.isEmpty() && totalCost.isEmpty() && supplier.equals("--") && item.equals("--"))) {

            String ask = "Are you sure you want to buy " + item + " for $/" + totalCost + " ?";
            int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                int numQty = Integer.parseInt(Qty);
                float numTotalCost = Float.parseFloat(totalCost);

                pi.setName(item);
                pi.setSupplier(supplier);
                pi.setQty(numQty);
                pi.setTotal_cost(numTotalCost);

                if (esql.newItemPurchase(item)) {
                    esql.buyItem(pi);
                    JOptionPane.showMessageDialog(null, "Successful purchase");
                    ClearItemPurchase();
                    loadItemPurchased();
                    cp.loadItems();
                } else {
                    esql.buyMoreItems(pi, numQty);
                    ClearItemPurchase();
                    loadItemPurchased();
                }
            }
        }
        return 0;
    }

    public void loadItemPurchased() {
        esql.itemPurchasedTable(table);
        view.ViewMain.setSuppliersPane2Table(table);
    }
    
    public void loadItemList() {
        esql.loadItemPurchasedList(itemList);
        view.ViewMain.setSuppliersPane2ItemList(itemList);
    }
    
    public void loadSupplierList() {
        esql.loadItemPurchasedSupplierList(supplierList);
        view.ViewMain.setSuppliersPane2SupplierList(supplierList);
    }

    public void searchItemPurchased() {
        String searchText = view.ViewMain.getSuppliersTxtSearch().getText().trim();
        if (!searchText.isEmpty()) {
            esql.searchItemPurchasedTable(table, searchText);
            ClearItemPurchase();
        }
    }

    public void mouseClickedItemPurchasedTable() {
        try {
            int row = table.getSelectedRow();

            String ITEM = table.getValueAt(row, 0).toString();
            String SUPPLIER = table.getValueAt(row, 1).toString();
            String QUANTITY = table.getValueAt(row, 2).toString();

            itemList.setSelectedItem(ITEM);
            supplierList.setSelectedItem(SUPPLIER);
            view.ViewMain.setSuppliersPane2TxtQuantity(QUANTITY);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void ClearItemPurchase() {
        view.ViewMain.setSuppliersPane2TxtQuantity("");
        view.ViewMain.setSuppliersPane2TxtTotalCost("");
        view.ViewMain.setSuppliersTxtSearch("");
        itemList.setSelectedIndex(0);
        supplierList.setSelectedIndex(0);
    }

    private boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String num) {
        try {
            Float.parseFloat(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
