package controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import model.DB;
import model.Invoice;
import model.Product;
import model.Sale;
import view.ViewInvoice;

public class ControlSales {

    private DB esql = new DB();
    private JTable table = view.ViewMain.getSaleTableProduct();
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList iList = view.ViewMain.getSaleProductList();
    private JComboBox cItem = view.ViewMain.getSaleProductCBox();
    private JLabel price = view.ViewMain.getSaleTxtPrice();
    private String discount = view.ViewMain.getSaleTxtDiscount().getText().trim();
    private int discountType = view.ViewMain.getSaleDiscountType().getSelectedIndex();// 0=$ | 1=%
    private String customerId = view.ViewMain.getSaleTxtCustomerId().getText().trim();
    private JLabel customerName = view.ViewMain.getSaleTxtCustomerName();
    private JLabel finalPrice = view.ViewMain.getSaleTxtTotalCost();
    private String pay = view.ViewMain.getSaleTxtCustomerPay().getText().trim();
    private String search = view.ViewMain.getSaleTxtProduct().getText().trim();
    private JList sList = view.ViewMain.getSaleSearchList();
    private JSpinner qty = view.ViewMain.getSaleTxtQty();
    private String employee = view.ViewMain.getSaleTxtEmployeeID().getText();
    Product prod = new Product();
    Sale sale = new Sale();

    public void loadProductsComboBox() {
        esql.loadSaleComboBox(cItem);
    }

    public void btnAddProduct() {
        try {
            String q = qty.getModel().getValue().toString().trim();
            boolean notEmptyItem = !cItem.getSelectedItem().equals("--");
            boolean notEmptyQty = !qty.getModel().getValue().toString().isBlank();
            boolean numericQty = isNumeric(q);
            if (notEmptyItem && notEmptyQty && numericQty) {
                String item = cItem.getSelectedItem().toString();
                int itemCount = iList.getModel().getSize();
                Map<String, Integer> list = new HashMap<>();

                if (itemCount == 0) {//if its the first item,create a Map and show the item in the table
                    int qt = Integer.parseInt(q);
                    list.put(item, qt);
                    esql.searchSaleProductsTable(table, item);
                    view.ViewMain.setSaleTableProduct(table);
                    price.setText(sumPrice(table, price.getText(), item, qt));
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
                    /*add the quantity*/
                    if (list.containsKey(item)) {
                        int qt = Integer.parseInt(q);
                        int newValue = list.get(item) + qt;
                        list.replace(item, newValue);
                        price.setText(sumPrice(table, price.getText(), item, qt));
                    } else {
                        int qt = Integer.parseInt(q);
                        list.put(item, qt);
                        esql.searchSaleProductsTable(table, item);
                        view.ViewMain.setSaleTableProduct(table);
                        price.setText(sumPrice(table, price.getText(), item, qt));
                    }
                }
                /*building the list*/
                for (Map.Entry<String, Integer> entry : list.entrySet()) {
                    listModel.addElement(entry.getKey() + " X" + entry.getValue());
                }
                iList.setModel(listModel);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }

    }

    public void btnRemoveProduct() {
        try {
            String q = qty.getModel().getValue().toString().trim();
            boolean notEmptyItem = !iList.isSelectionEmpty();
            boolean notEmptyQty = !qty.getModel().getValue().toString().isBlank();
            boolean numericQty = isNumeric(q);
            String item = cItem.getSelectedItem().toString();
            int itemCount = iList.getModel().getSize();

            for (int i = 0; i < itemCount; i++) {
                listModel.addElement(iList.getModel().getElementAt(i).toString());
            }
            /*if any item is selected by click*/
            if (notEmptyItem && notEmptyQty && numericQty) {
                int qt = Integer.parseInt(q);
                String str = iList.getSelectedValue().toString();
                for (int j = str.length(); j > 0; j--) {
                    if (str.charAt(j - 1) == 'X') {
                        int value = Integer.parseInt(str.substring(j));
                        if (value <= 1) {
                            /*if there is only one product left it will be removed from the list*/
                            listModel.remove(iList.getSelectedIndex());
                            price.setText(subPrice(table, price.getText(), item, qt, value));
                            deleteFromTable(table, str);
                            view.ViewMain.setSaleTableProduct(table);
                            break;
                        } else {
                            /*if there is more than one product in the list, remove one (e.g: milk X5 -> milk X4)*/
                            String itemName = str.substring(0, j - 2) + " X";
                            int newRes = value - qt;
                            if (newRes <= 0) {
                                listModel.remove(iList.getSelectedIndex());
                                price.setText(subPrice(table, price.getText(), item, qt, value));
                                deleteFromTable(table, str);
                                view.ViewMain.setSaleTableProduct(table);
                            } else {
                                listModel.setElementAt(itemName + newRes, iList.getSelectedIndex());
                                price.setText(subPrice(table, price.getText(), item, qt, value));
                            }
                        }
                        break;
                    }
                }
            } /*if the item is selected by the comboBox list*/ else if (!item.equals("--")) {
                for (int i = 0; i < itemCount; i++) {
                    /*cheking if the product in the comboBox is equal to the one in the list*/
                    String str = iList.getModel().getElementAt(i).toString();
                    boolean same = str.length() > item.length() && item.equals(str.substring(0, item.length()));
                    if (same) {
                        for (int j = str.length(); j > 0; j--) {
                            if (str.charAt(j - 1) == 'X') {
                                int value = Integer.parseInt(str.substring(j));
                                if (value <= 1) {
                                    /*if there is only one product left it will be removed from the list*/
                                    listModel.removeElementAt(i);
                                    int qt = Integer.parseInt(q);
                                    price.setText(subPrice(table, price.getText(), item, qt, value));
                                    deleteFromTable(table, str);
                                    view.ViewMain.setSaleTableProduct(table);
                                    break;
                                } else {
                                    /*if there is more than one product in the list, remove one (e.g: milk X5 -> milk X4)*/
                                    String itemName = str.substring(0, j - 2) + " X";
                                    int qt = Integer.parseInt(q);
                                    int newRes = value - qt;
                                    if (newRes <= 0) {
                                        listModel.removeElementAt(i);
                                        price.setText(subPrice(table, price.getText(), item, qt, value));
                                        deleteFromTable(table, str);
                                        view.ViewMain.setSaleTableProduct(table);
                                    } else {
                                        listModel.setElementAt(itemName + newRes, i);
                                        price.setText(subPrice(table, price.getText(), item, qt, value));
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            iList.setModel(listModel);
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }

    }

    public void btnSearchProduct() {
        try {
            if (!search.isBlank()) {
                if (isNumeric(search)) {
                    int numSearch = Integer.parseInt(search);
                    esql.searchSaleProductsList(sList, numSearch);
                    view.ViewMain.setSaleSearchList(sList);
                } else {
                    esql.searchSaleProductsList(sList, search);
                    view.ViewMain.setSaleSearchList(sList);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public void mouseClickedProductList() {
        try {
            if (iList.getSelectedIndex() >= 0) {
                String itemX = iList.getSelectedValue().toString();
                String item = "";
                String X = "";
                for (int j = itemX.length(); j > 0; j--) {
                    if (itemX.charAt(j - 1) == 'X') {
                        item = itemX.substring(0, j - 2);
                        X = itemX.substring(j);
                        break;
                    }
                }
                cItem.setSelectedItem(item);
                qty.getModel().setValue(Integer.parseInt(X));
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public void mouseClickedSearchList() {
        try {
            if (sList.getSelectedIndex() >= 0) {
                cItem.setSelectedItem(sList.getSelectedValue().toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private String sumPrice(JTable table, String currentPrice, String item, int X) {
        try {
            int rowCount = table.getRowCount();
            String itemPrice = "0";
            for (int i = 0; i < rowCount; i++) {
                if (table.getValueAt(i, 2).toString().equals(item)) {
                    itemPrice = table.getValueAt(i, 3).toString();
                }
            }
            float increment = Float.parseFloat(itemPrice);
            float current = Float.parseFloat(currentPrice);
            float sum = current + (increment * X);
            String result = String.format(java.util.Locale.US, "%.2f", sum);
            return result;
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    private String subPrice(JTable table, String currentPrice, String item, int X, int value) {
        try {
            int rowCount = table.getRowCount();
            String itemPrice = "0";
            for (int i = 0; i < rowCount; i++) {
                if (table.getValueAt(i, 2).toString().equals(item)) {
                    itemPrice = table.getValueAt(i, 3).toString();
                }
            }
            float substract = Float.parseFloat(itemPrice);
            float current = Float.parseFloat(currentPrice);
            if (X > value) {
                X = value;
            }
            float sub = current - (substract * X);
            if (sub <= 0) {
                return "0.00";
            }
            String result = String.format(java.util.Locale.US, "%.2f", sub);
            return result;
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    private void deleteFromTable(JTable table, String name) {
        try {
            int rowCount = table.getRowCount();
            int end = 0;
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int j = name.length(); j > 0; j--) {
                if (name.charAt(j - 1) == 'X') {
                    end = j - 2;
                }
            }
            for (int i = 0; i < rowCount; i++) {
                if (table.getValueAt(i, 2).equals(name.substring(0, end))) {
                    model.removeRow(i);
                    break;
                }
            }
            table.setModel(model);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void directFinalPrice() {
        try {
            if (discount.isBlank()) {
                finalPrice.setText(price.getText());
            } else if (!discount.isBlank() && isFloat(discount)) {
                float cost = Float.parseFloat(price.getText());
                float dis = Float.parseFloat(discount);
                if (discountType == 0) {//0 means $, direct discount
                    float result = cost - dis;
                    if (result <= 0) {
                        result = 0;
                        finalPrice.setText("0.00");
                    } else {
                        finalPrice.setText(String.valueOf(result));
                    }
                } else if (discountType == 1) {//1 means %, percentage
                    float percentage = (dis * cost) / 100;
                    float result = cost - percentage;
                    if (result <= 0) {
                        result = 0;
                        finalPrice.setText("0.00");
                    } else {
                        String r = String.format(java.util.Locale.US, "%.2f", result);
                        finalPrice.setText(String.valueOf(r));
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }
    public void discountFinalPrice() {
        try {
            if (!price.getText().isBlank() && isFloat(discount)) {
                float cost = Float.parseFloat(price.getText());
                float dis = Float.parseFloat(discount);
                if (discountType == 0) {//0 = $, direct discount
                    float result = cost - dis;
                    if (result <= 0) {
                        result = 0;
                        finalPrice.setText("0.00");
                    } else {
                        finalPrice.setText(String.valueOf(result));
                    }
                } else if (discountType == 1) {//1 = %, percentage
                    float percentage = (dis * cost) / 100;
                    float result = cost - percentage;
                    if (result <= 0) {
                        result = 0;
                        finalPrice.setText("0.00");
                    } else {
                        String r = String.format(java.util.Locale.US, "%.2f", result);
                        finalPrice.setText(String.valueOf(r));
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public void btnSearchCustomer() {
        try {
            if (isNumeric(customerId)) {
                int cusId = Integer.parseInt(customerId);
                esql.searchSaleCustomer(cusId, customerName);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public void btnClearCustomer() {
        view.ViewMain.getSaleTxtCustomerId().setText("");
        customerName.setText("");
    }

    public void btnClearAll() {
        try {
            view.ViewMain.getSaleTxtProduct().setText("");
            DefaultListModel listModel1 = new DefaultListModel();
            iList.setModel(listModel1);
            sList.setModel(listModel1);
            view.ViewMain.getSaleTxtQty().setValue(1);
            view.ViewMain.getSaleTxtPrice().setText("0.00");
            view.ViewMain.getSaleTxtDiscount().setText("");
            view.ViewMain.getSaleTxtCustomerId().setText("");
            view.ViewMain.getSaleTxtCustomerPay().setText("");
            cItem.setSelectedIndex(0);
            customerName.setText("");
            finalPrice.setText("0.00");
            var tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void btnPay() {
        if (!pay.isEmpty()) {
            float final_cost = Float.parseFloat(finalPrice.getText());
            float cost = Float.parseFloat(price.getText());
            int seller = 5;
            if (!employee.equals("")) {
                seller = Integer.parseInt(employee);
            }
            boolean notEmptyProducts = iList.getModel().getSize() > 0;
            boolean unregisteredCustomer = !customerName.getText().equals("");
            boolean validPayment = !pay.isEmpty() && isFloat(pay);
            float final_pay = Float.parseFloat(pay);
            boolean validTransaction = final_cost <= final_pay;
            int cusId = 6;
            if (!customerId.equals("")) {
                cusId = Integer.parseInt(customerId);
            }
            boolean allRight = notEmptyProducts && validPayment && validTransaction && (discount.isEmpty() || (!discount.isEmpty() && isFloat(discount)));

            if (!notEmptyProducts) {
                JOptionPane.showMessageDialog(null, "No products in cart", "Error", JOptionPane.PLAIN_MESSAGE);
            } else if (!validPayment) {
                JOptionPane.showMessageDialog(null, "Insert valid payment(only numbers or decimals)", "Error", JOptionPane.PLAIN_MESSAGE);
            } else if (!discount.isEmpty() && !isFloat(discount)) {
                JOptionPane.showMessageDialog(null, "Insert valid discount(only numbers or decimals)", "Error", JOptionPane.PLAIN_MESSAGE);
            } else if (!validTransaction) {
                JOptionPane.showMessageDialog(null, "The cost exceeds the payment", "Error", JOptionPane.PLAIN_MESSAGE);
            } else if (allRight) {
                sale.setProducts(itemListToString(iList));
                sale.setDiscount("0");
                if (!discount.isEmpty()) {
                    sale.setDiscount(discountType + " " + discount);
                }
                if (unregisteredCustomer) {
                    sale.setCustomer(0);
                } else {
                    sale.setCustomer(cusId);
                }
                sale.setFinal_cost(final_cost);
                sale.setCost(cost);
                sale.setEmployee(seller);
                if (checkProducts(iList, table)) {
                    var prods = new ArrayList();
                    var Qty = new ArrayList();
                    productArrayList(iList, prods, Qty);
                    esql.updateProductsAfterSale(prods, Qty);
                    esql.addSale(sale);
                    String ask = "Do you want to print the invoice?";
                    int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        ViewInvoice vi = new ViewInvoice(fillInvoice(prods, Qty));
                        vi.showWindow();
                    }
                    btnClearAll();
                }
            }
        }
    }

    private Invoice fillInvoice(ArrayList name, ArrayList qty) {
        Invoice inv = new Invoice();
        Timestamp tsldt = Timestamp.valueOf(LocalDateTime.now());
        String date = tsldt.toString();
        JTable tabl = new JTable();
        String[] columnNames = {"Name", "Quantity", "Price"};
        String[][] data = new String[qty.size()][columnNames.length];
        for (int i = 0; i < qty.size(); i++) {
            data[i][0] = name.get(i).toString();
            data[i][1] = qty.get(i).toString();
            data[i][2] = price(name.get(i).toString());
        }
        DefaultTableModel model1 = new DefaultTableModel(data, columnNames);
        tabl.setModel(model1);

        inv.setTotal(finalPrice.getText());
        inv.setDate(date.substring(0, date.length() - 11));
        inv.setTable(tabl);
        if(!discount.isBlank() && isFloat(discount)){
            inv.setDiscount(discount);
        }else{
            inv.setDiscount("0.00");
        }
        return inv;
    }

    private String price(String name) {
        for (int i = 0; i < table.getModel().getRowCount(); i++) {
            boolean match = table.getValueAt(i, 2).toString().equals(name);
            if (match) {
                return table.getValueAt(i, 3).toString();
            }
        }
        return "";
    }

    private boolean checkProducts(JList list, JTable table) {
        ArrayList prods = new ArrayList();
        ArrayList Qty = new ArrayList();
        productArrayList(list, prods, Qty);
        int match = 0;
        for (int i = 0; i < prods.size(); i++) {
            for (int j = 0; j < table.getRowCount(); j++) {
                /*cheking if the name of the product in the list match one in the table to compare the quantity on stock with the quantity in the cart*/
                boolean matchName = prods.get(i).toString().equals(table.getValueAt(j, 2).toString());
                int prodQty = Integer.valueOf((String) Qty.get(i));
                int tableQty = Integer.parseInt(table.getValueAt(j, 4).toString());
                boolean matchQty = prodQty <= tableQty;
                if (matchName && matchQty) {
                    match++;
                    break;
                }
            }
        }
        return match == prods.size();
    }

    private void productArrayList(JList list, ArrayList arrProd, ArrayList arrQty) {
        ListModel model = list.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            String str = model.getElementAt(i).toString();
            for (int j = str.length(); j > 0; j--) {
                if (str.charAt(j - 1) == 'X') {
                    arrProd.add(str.substring(0, j - 2));
                    arrQty.add(str.substring(j));
                    break;
                }
            }
        }
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
