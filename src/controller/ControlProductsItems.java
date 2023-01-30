package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;
import model.Item;
import controller.ControlProducts;

public class ControlProductsItems {

    private String name = view.ViewMain.getProductsPane4TxtItemName().getText().trim();
    private String measure = view.ViewMain.getProductsPane4ItemMeasureType().getSelectedItem().toString();
    private JTable table = view.ViewMain.getProductsPane4Table();
    private DB esql = new DB();
    private Item item = new Item();
    private ControlProducts cp = new ControlProducts();
    private ControlSuppliersItems cs = new ControlSuppliersItems();

    public boolean addItem() {
        if (!name.isEmpty() && esql.newItem(name)) {
            item.setName(name);
            item.setUnit(measure);
            esql.addItem(item);
            JOptionPane.showMessageDialog(null, "Item added");
            cs.loadItemList();
            cp.loadItems();
            Clear();
            loadItems();
            return true;
        }
        return false;
    }

    public void mouseClickedItemsTable() {
        try {
            int row = table.getSelectedRow();
            JComboBox cb = view.ViewMain.getProductsPane4ItemMeasureType();

            String namec = table.getValueAt(row, 1).toString();
            String unitMeasure = table.getValueAt(row, 2).toString();
            cb.setSelectedItem(unitMeasure);

            view.ViewMain.setProductsPane4TxtItemName(namec);
            view.ViewMain.setProductsPane4ItemMeasureType(cb);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deleteItem()  {
        String ask = "Are you sure you want to delete " + name + " from your Items?";
        int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
        if (answer == JOptionPane.YES_OPTION) {
            esql.removeItem(name);
            cs.loadItemList();
            cp.loadItems();
            Clear();
            loadItems();
        }
    }

    public void saveItem() {
        int columns = table.getColumnCount();
        for (int i = 0; i < columns; i++) {
            if (table.isColumnSelected(i)) {
                item.setUnit(measure);
                item.setName(name);
                int row = table.getSelectedRow();
                String lastName = table.getValueAt(row, 1).toString();
                if (esql.updateItem(item, lastName)) {
                    JOptionPane.showMessageDialog(null, "Changes saved");
                    cp.loadItems();
                    cs.loadItemList();
                    Clear();
                    loadItems();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select the item in the table");
            }
        }
    }

    public void searchItem() {
        String searchText = view.ViewMain.getProductsTxtSearch().getText().trim();
        if (!searchText.isEmpty()) {
            if (isNumeric(searchText) && esql.searchItemTable(table, Integer.parseInt(searchText))) {
                esql.searchItemTable(table, searchText);
            } else if(!isNumeric(searchText)){
                esql.searchItemTable(table, searchText);
            }
            Clear();
        }
    }

    public void loadItems() {
        esql.itemsTable(table);
        view.ViewMain.setProductsPane4Table(table);
    }

    public void Clear() {
        view.ViewMain.setProductsPane4TxtItemName("");
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
