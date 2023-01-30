package controller;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;
import model.Supplier;

public class ControlSuppliersInfo {

    private String name = view.ViewMain.getSuppliersPane1TxtName().getText().trim();
    private String docT = view.ViewMain.getSuppliersPane1DocumentType().getSelectedItem().toString();
    private String docNum = view.ViewMain.getSuppliersPane1TxtDocumentNumber().getText().trim();
    private String phone = view.ViewMain.getSuppliersPane1TxtPhone().getText().trim();
    private JTable table = view.ViewMain.getSuppliersPane1Table();
    private DB esql = new DB();
    private Supplier sup = new Supplier();
    private ControlSuppliersItems cs = new ControlSuppliersItems();

    public byte addSupplier() {
        if (name.isEmpty() && docNum.isEmpty() && phone.isEmpty()) {
            //ignore
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert the supplier's name", "Error", JOptionPane.PLAIN_MESSAGE);
            return 1;
        } else if (docNum.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert document numer", "Error", JOptionPane.PLAIN_MESSAGE);
            return 2;
        } else if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert a phone number", "Error", JOptionPane.PLAIN_MESSAGE);
            return 3;
        } else if (!(name.isEmpty() && docNum.isEmpty() && phone.isEmpty())) {

            if (esql.newSupplier(name)) {
                sup.setName(name);
                sup.setDocType(docT);
                sup.setDocNum(Integer.parseInt(docNum));
                sup.setPhone(Integer.parseInt(phone));
                if (esql.addSupplier(sup)) {
                    JOptionPane.showMessageDialog(null, "Supplier registered successfully");
                    loadSuppliersTable();
                    cs.loadSupplierList();
                    Clear();
                    return 4;
                } else {
                    JOptionPane.showMessageDialog(null, "Unexpected error", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Supplier already exist", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
        return 0;
    }

    public void saveSupplier() {
        if (!name.isBlank() && !docNum.isBlank() && !phone.isBlank() && isNumeric(phone) && isNumeric(docNum)) {
            sup.setName(name);
            sup.setDocType(docT);
            sup.setDocNum(Integer.parseInt(docNum));
            sup.setPhone(Integer.parseInt(phone));
            esql.updateSupplier(sup);
            loadSuppliersTable();
            cs.loadSupplierList();
        }
    }

    public void searchSupplier() {
        String searchText = view.ViewMain.getSuppliersTxtSearch().getText().trim();
        if (!searchText.isEmpty()) {
            if (isNumeric(searchText) && esql.searchSuppliersTable(table, Integer.parseInt(searchText))) {
                esql.searchSuppliersTable(table, searchText);
            } else if (!isNumeric(searchText)) {
                esql.searchSuppliersTable(table, searchText);
            }
        }
    }

    public void loadSuppliersTable() {
        esql.suppliersInfoTable(table);
        view.ViewMain.setSuppliersPane1Table(table);
    }

    public void mouseClickedSuppliersTable() {
        try {
            int row = table.getSelectedRow();
            JComboBox cb = view.ViewMain.getSuppliersPane1DocumentType();

            String namec = table.getValueAt(row, 1).toString();
            String docTypec = table.getValueAt(row, 2).toString();
            cb.setSelectedItem(docTypec);
            String docNumc = table.getValueAt(row, 3).toString();
            String phonec = table.getValueAt(row, 4).toString();

            view.ViewMain.setSuppliersPane1TxtName(namec);
            view.ViewMain.setSuppliersPane1DocumentType(cb);
            view.ViewMain.setSuppliersPane1TxtDocumentNumber(docNumc);
            view.ViewMain.setSuppliersPane1TxtPhone(phonec);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deleteSupplier() {
        if (!name.isEmpty()) {
            String ask = "Are you sure you want to delete " + name + " from your suppliers?";
            int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                esql.removeSupplier(name);
                loadSuppliersTable();
                cs.loadSupplierList();
            }
        }
    }

    public void Clear() {
        view.ViewMain.setSuppliersTxtSearch("");
        view.ViewMain.setSuppliersPane1TxtName("");
        view.ViewMain.setSuppliersPane1TxtDocumentNumber("");
        view.ViewMain.setSuppliersPane1TxtPhone("");
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
