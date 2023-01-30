package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import model.DB;
import model.Product;

public class ControlProducts {

    private String code = view.ViewMain.getProductsPane2TxtProductCode().getText().trim();
    private String name = view.ViewMain.getProductsPane2TxtProductName().getText().trim();
    private String price = view.ViewMain.getProductsPane2ProductPrice().getText().trim();
    private String pLine = view.ViewMain.getProductsPane2ProductLine().getSelectedItem().toString();
    private JComboBox cItem = view.ViewMain.getProductsPane2Item();
    private String pItem = view.ViewMain.getProductsPane2Item().getSelectedItem().toString();
    private String searchText = view.ViewMain.getProductsTxtSearch().getText().trim();
    private JList iList = view.ViewMain.getProductsPane2ItemList();
    private boolean emptyLine = view.ViewMain.getProductsPane2ProductLine().getItemCount() <= 1;
    private boolean emptyItem = view.ViewMain.getProductsPane2Item().getItemCount() <= 1;
    private boolean emptyIList = iList.getModel().getSize() <= 0;
    private DB esql = new DB();
    private Product prod = new Product();
    private JTable table = view.ViewMain.getProductsPane2Table();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private ControlSales s = new ControlSales();
    private ControlProductsTable cpt = new ControlProductsTable();
    private ControlProductStock cps = new ControlProductStock();

    MouseListener ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClickedProductsTable(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };

    public byte addProduct() {
        if (code.isEmpty() && name.isEmpty() && price.isEmpty()) {
            /*ignore*/
            return 1;
        } else if (code.isEmpty() || !isNumeric(code)) {
            JOptionPane.showMessageDialog(null, "Insert a valid number(only integers)", "Error", JOptionPane.PLAIN_MESSAGE);
            return 2;
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert product name", "Error", JOptionPane.PLAIN_MESSAGE);
            return 3;
        } else if (price.isEmpty() || !isFloat(price)) {
            JOptionPane.showMessageDialog(null, "Insert a valid price", "Error", JOptionPane.PLAIN_MESSAGE);
            return 4;
        } else if (pLine.equals("--")) {
            if (emptyLine) {
                JOptionPane.showMessageDialog(null, "You need a product line, add one", "Error", JOptionPane.PLAIN_MESSAGE);
                return 5;
            } else {
                JOptionPane.showMessageDialog(null, "Select product line", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (pItem.equals("--")) {
            if (emptyItem) {
                JOptionPane.showMessageDialog(null, "You need an item, add one", "Error", JOptionPane.PLAIN_MESSAGE);
                return 6;
            } else {
                JOptionPane.showMessageDialog(null, "Select item", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (emptyIList) {
            JOptionPane.showMessageDialog(null, "Add at least one item to the product", "Error", JOptionPane.PLAIN_MESSAGE);
        } else if (!(code.isEmpty() && name.isEmpty() && price.isEmpty() && emptyLine && emptyItem && emptyIList)) {
            int nCode = Integer.parseInt(code);
            float nPrice = Float.parseFloat(price);

            prod.setCode(nCode);
            prod.setName(name);
            prod.setPrice(nPrice);
            prod.setLine(pLine);
            prod.setItems(itemListToString(iList));
            if (esql.newProduct(prod)) {
                if (esql.addProduct(prod)) {
                    s.loadProductsComboBox();
                    cpt.loadProductsTable();
                    cps.loadProductStockTable();
                    cps.loadProducts();
                    Clear();
                    JOptionPane.showMessageDialog(null, "Product added");
                } else {
                    JOptionPane.showMessageDialog(null, "Product name already exist, try another one", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product code already exist, try another one", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
        return 0;
    }

    public void loadProducts() {
        JComboBox cbLine = view.ViewMain.getProductsPane2ProductLine();
        JComboBox cbItems = view.ViewMain.getProductsPane2Item();
        esql.loadItems(cbItems);
        esql.loadProductLines(cbLine);
        view.ViewMain.setProductsPane2ProductLine(cbLine);
        view.ViewMain.setProductsPane2Item(cbItems);
    }

    public void loadProductsTable() {
        table = esql.productsTable();
        table.addMouseListener(ml);
        JScrollPane sp = view.ViewMain.getjScrollPane9();
        sp.setViewportView(table);
        view.ViewMain.setjScrollPane9(sp);
    }

    private String itemListToString(JList list) {
        int itemCount = list.getModel().getSize();
        String result = "";
        for (int i = 0; i < itemCount; i++) {
            if (i == itemCount - 1) {
                result = result + list.getModel().getElementAt(i).toString();
            } else {
                result = result + list.getModel().getElementAt(i).toString() + ";";
            }
        }
        return result;
    }

    public void btnAddItem() {
        if (!cItem.getSelectedItem().equals("--")) {
            String item = cItem.getSelectedItem().toString();
            int itemCount = iList.getModel().getSize();
            Map<String, Integer> list = new HashMap<>();

            if (itemCount == 0) {//if its the first item,create a Map
                list.put(item, 1);
            } else {//if its not the first, parse from the list to a Map
                for (int i = 0; i < itemCount; i++) {
                    String key = iList.getModel().getElementAt(i).toString();
                    int length = key.length();
                    int value = 0;
                    for (int j = length; j > 0; j--) {//look for the last X eg: "SomeCola X7"
                        if (key.charAt(j - 1) == 'X') {
                            value = Integer.parseInt(key.substring(j));//the value in the example is 7
                            String newKey = key.substring(0, j - 2);//and the item is SomeCola
                            list.put(newKey, value);
                            break;
                        }
                    }
                }
                /*add a token to an existing item stock or create one*/
                if (list.containsKey(item)) {
                    int newValue = list.get(item) + 1;
                    list.replace(item, newValue);
                } else {
                    list.put(item, 1);
                }
            }
            /*building the list*/
            for (Map.Entry<String, Integer> entry : list.entrySet()) {
                listModel.addElement(entry.getKey() + " X" + entry.getValue());
            }
            iList.setModel(listModel);
        }
    }

    public void btnRemoveItem() {
        String item = cItem.getSelectedItem().toString();
        int itemCount = iList.getModel().getSize();

        for (int i = 0; i < itemCount; i++) {
            listModel.addElement(iList.getModel().getElementAt(i).toString());
        }
        /*if any item is selected by click*/
        if (!iList.isSelectionEmpty()) {
            String str = iList.getSelectedValue().toString();
            for (int j = str.length(); j > 0; j--) {
                if (str.charAt(j - 1) == 'X') {
                    int value = Integer.parseInt(str.substring(j));
                    if (value <= 1) {
                        /*if there is only one product left it will be removed from the list*/
                        listModel.remove(iList.getSelectedIndex());
                        break;
                    } else {
                        /*if there is more than one product in the list, remove one (e.g: milk X5 -> milk X4)*/
                        String itemName = str.substring(0, j - 2) + " X";
                        value -= 1;
                        listModel.setElementAt(itemName + value, iList.getSelectedIndex());
                    }
                    break;
                }
            }
        } /*if the item is selected by the comboBox list*/ else if (!item.equals("--")) {
            for (int i = 0; i < itemCount; i++) {
                String str = iList.getModel().getElementAt(i).toString();
                boolean same = str.length() > item.length() && item.equals(str.substring(0, item.length()));
                if (same) {
                    for (int j = str.length(); j > 0; j--) {
                        if (str.charAt(j - 1) == 'X') {
                            int value = Integer.parseInt(str.substring(j));
                            if (value <= 1) {
                                listModel.removeElementAt(i);
                                break;
                            } else {
                                String itemName = str.substring(0, j - 2) + " X";
                                value -= 1;
                                listModel.setElementAt(itemName + value, i);
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        iList.setModel(listModel);
    }

    public void deleteProduct() {
        JViewport vp = view.ViewMain.getjScrollPane9().getViewport();
        JTable t = (JTable) vp.getView();
        if (t.getSelectedRow() >= 0) {
            String ask = "Are you sure you want to delete the product " + name + " with code " + code + " from your products?";
            int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(t.getValueAt(t.getSelectedRow(), 0).toString());
                int prod_qty = Integer.parseInt(t.getValueAt(t.getSelectedRow(), 4).toString());
                String items = "";
                esql.loadItemList(items, id);
                int nCode = Integer.parseInt(code);
                if (esql.removeProduct(nCode)) {
                    if(prod_qty>0){esql.releaseItems(itemsList_Qty(items, prod_qty));}
                    s.loadProductsComboBox();
                    cps.loadProductStockTable();
                    cps.loadProducts();
                    cpt.loadProductsTable();
                    loadProductsTable();
                    JOptionPane.showMessageDialog(null, "Product removed");
                } else {
                    JOptionPane.showMessageDialog(null, "Unexpected error", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } else {
            System.out.println(t.getRowCount());
            JOptionPane.showMessageDialog(null, "Select the product in the table");
        }
    }

    public void mouseClickedProductsTable(MouseEvent e) {
        try {
            listModel.removeAllElements();
            int row = table.rowAtPoint(e.getPoint());
            JComboBox cb1 = view.ViewMain.getProductsPane2ProductLine();
            String codec = table.getValueAt(row, 1).toString();
            String namec = table.getValueAt(row, 2).toString();
            String pricec = table.getValueAt(row, 3).toString();
            String linec = table.getValueAt(row, 4).toString();
            int id = Integer.parseInt(table.getValueAt(row, 0).toString());
            String str = "";

            String list = esql.loadItemList(str, id);
            for (int i = 0; i < list.length(); i++) {
                if (list.charAt(i) == ';') {
                    listModel.addElement(list.substring(0, i));
                    list = list.substring(i + 1);
                    i = 0;
                } else if (i == list.length() - 1 && list.length() > 0) {
                    listModel.addElement(list.substring(0, i + 1));
                }
            }
            view.ViewMain.setProductsPane2TxtProductCode(codec);
            view.ViewMain.setProductsPane2TxtProductName(namec);
            view.ViewMain.setProductsPane2ProductPrice(pricec);
            cb1.setSelectedItem(linec);
            iList.setModel(listModel);
        } catch (NumberFormatException ex) {
            System.out.println(ex.toString());
        }
    }

    public void mouseClickedProductList() {
        if (iList.getSelectedValue() != null) {
            String itemX = iList.getSelectedValue().toString();
            String item = itemX.substring(0, itemX.length() - 3);
            cItem.setSelectedItem(item);
        }
    }

    public void loadItems() {
        JComboBox cbItems = view.ViewMain.getProductsPane2Item();
        esql.loadItems(cbItems);
        view.ViewMain.setProductsPane2Item(cbItems);
    }

    public void loadLines() {
        JComboBox cbLine = view.ViewMain.getProductsPane2ProductLine();
        esql.loadProductLines(cbLine);
        view.ViewMain.setProductsPane2ProductLine(cbLine);
    }

    public void Clear() {
        view.ViewMain.setProductsPane2TxtProductCode("");
        view.ViewMain.setProductsPane2TxtProductName("");
        view.ViewMain.setProductsPane2ProductPrice("");
        view.ViewMain.getProductsPane2ProductLine().setSelectedIndex(0);
        view.ViewMain.getProductsPane2Item().setSelectedIndex(0);
        iList.setModel(listModel);
        view.ViewMain.setProductsTxtSearch("");
        loadProductsTable();
    }

    public void searchLine() {
        if (!searchText.isEmpty() && isNumeric(searchText)) {
            int id_code = Integer.parseInt(searchText);
            JScrollPane sp = view.ViewMain.getjScrollPane9();
            if (esql.searchProductsTableById(id_code)) {
                table = esql.searchProductsTable("id", id_code);
                table.addMouseListener(ml);
                sp.setViewportView(table);
                view.ViewMain.setjScrollPane9(sp);
            } else if (esql.searchProductsTableByCode(id_code)) {
                table = esql.searchProductsTable("code", id_code);
                table.addMouseListener(ml);
                sp.setViewportView(table);
                view.ViewMain.setjScrollPane9(sp);
            } else {
                JOptionPane.showMessageDialog(null, "Product not found", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private ArrayList itemsList_Qty(String itemList, int Qty) {
        ArrayList list = new ArrayList();
        int item_qty = 0;
        int total_qty = 0;
        String item = "";
        for (int i = itemList.length(); i > 0; i--) {
            if (itemList.charAt(i - 1) == 'X') {
                item_qty = Integer.parseInt(itemList.substring(i));
                total_qty = item_qty * Qty;
                list.add(total_qty);
                itemList = itemList.substring(0, i - 2);
                i = itemList.length();
            } else if (itemList.charAt(i - 1) == ';') {
                item = itemList.substring(i);
                list.add(item);
                itemList = itemList.substring(0, i - 1);
                i = itemList.length();
            }else if(i==1){
                list.add(itemList);
            }
        }
        return list;
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
