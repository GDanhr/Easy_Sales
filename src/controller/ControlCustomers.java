package controller;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Customer;
import model.DB;

public class ControlCustomers {

    private String ID = view.ViewMain.getCustomersTxtDocumentId().getText().trim();
    private String name = view.ViewMain.getCustomersTxtName().getText().trim();
    private String lastname = view.ViewMain.getCustomersTxtLastname().getText().trim();
    private String email = view.ViewMain.getCustomersTxtEmail().getText().trim();
    private String phone = view.ViewMain.getCustomersTxtPhone().getText().trim();

    JTable table = view.ViewMain.getCustomersTable();
    DB esql = new DB();
    Customer c = new Customer();

    public void loadCustomer() {
        esql.customersTable(table);
        view.ViewMain.setCustomersTable(table);
    }

    public byte addCustomer()  {
        if (name.isEmpty() && ID.isEmpty() && lastname.isEmpty()) {
            //ignore
        } else if (ID.isEmpty() || !isNumeric(ID)) {
            JOptionPane.showMessageDialog(null, "Insert valid document number", "Error", JOptionPane.PLAIN_MESSAGE);
            return 1;
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert customer name", "Error", JOptionPane.PLAIN_MESSAGE);
            return 2;
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert customer lastname", "Error", JOptionPane.PLAIN_MESSAGE);
            return 3;
        } else if (!(name.isEmpty() && ID.isEmpty() && lastname.isEmpty() && (!isNumeric(ID)))) {
            int NID = Integer.parseInt(ID);

            if (esql.newCustomer(NID)) {
                c.setCustomer_Document_Id(NID);
                c.setCustomer_Name(name);
                c.setCustomer_Lastname(lastname);
                if (!email.isEmpty()) {
                    c.setCustomer_email(email);
                }
                if (!phone.isEmpty()) {
                    int nphone = Integer.parseInt(phone);
                    c.setCustomer_Phone(nphone);
                }
                if (esql.addCustomer(c)) {
                    JOptionPane.showMessageDialog(null, "Customer registered successfully");
                    Clear();
                    return 4;
                } else {
                    JOptionPane.showMessageDialog(null, "Unexpected error", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Customer already exist", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
        return 0;
    }

    public char saveCustomer() {
        if (name.isEmpty() && ID.isEmpty() && lastname.isEmpty()) {
            //ignore
        } else if (ID.isEmpty() || isNumeric(ID)) {
            JOptionPane.showMessageDialog(null, "Insert valid document number", "Error", JOptionPane.PLAIN_MESSAGE);
            return 'a';
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert customer name", "Error", JOptionPane.PLAIN_MESSAGE);
            return 'b';
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert customer lastname", "Error", JOptionPane.PLAIN_MESSAGE);
            return 'c';
        } else if (!(name.isEmpty() && ID.isEmpty() && lastname.isEmpty()) && isNumeric(phone)) {
            int nphone = Integer.parseInt(phone);
            if (table.getSelectedRow() >= 0) {
                c.setCustomer_Name(name);
                c.setCustomer_Lastname(lastname);
                c.setCustomer_email(email);
                c.setCustomer_Phone(nphone);

                int row = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                if (esql.updateCustomer(c)) {
                    JOptionPane.showMessageDialog(null, "Customer updated successfully");
                    Clear();
                    return 'z';
                } else {
                    JOptionPane.showMessageDialog(null, "Unexpected error", "Error", JOptionPane.PLAIN_MESSAGE);
                    return 'd';
                }
            }
        }
        return '0';
    }

    public void deleteCustomer()  {
        try {
            if (table.getSelectedRow() >= 0) {
                int row = table.getSelectedRow();
                String namec = table.getValueAt(row, 2).toString();
                String lastnamec = table.getValueAt(row, 3).toString();
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                String ask = "Are you sure you want to delete " + namec +" "+ lastnamec + " with Document id: " + id + " from your customers?";
                int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    esql.removeCustomer(id);
                    Clear();
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public void mouseClickedCustomer() {
        try {
            int row = table.getSelectedRow();
            String id = table.getValueAt(row, 1).toString();
            String n = table.getValueAt(row, 2).toString();
            String ln = table.getValueAt(row, 3).toString();
            String e = "";
            /*check if email is empty*/
            if (!(table.getValueAt(row, 4) == null)) {
                e = table.getValueAt(row, 4).toString();
            }
            /*check if phone is empty*/
            String p = "";
            if (!(table.getValueAt(row, 5) == null)) {
                p = table.getValueAt(row, 5).toString();
            }

            view.ViewMain.setCustomersTxtDocumentId(id);
            view.ViewMain.setCustomersTxtName(n);
            view.ViewMain.setCustomersTxtLastname(ln);
            view.ViewMain.setCustomersTxtEmail(e);
            view.ViewMain.setCustomersTxtPhone(p);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void searchLine()  {
        try {
            String searchText = view.ViewMain.getCustomersTxtSearch().getText().trim();
            if (!searchText.isEmpty()) {
                if (isNumeric(searchText)) {
                    esql.searchCustomerTable(table, Integer.parseInt(searchText));
                } else {
                    if (!esql.searchCustomerTable(table, searchText, true)) {
                        esql.searchCustomerTable(table, searchText, false);
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public void Clear()  {
        view.ViewMain.setCustomersTxtDocumentId("");
        view.ViewMain.setCustomersTxtName("");
        view.ViewMain.setCustomersTxtLastname("");
        view.ViewMain.setCustomersTxtEmail("");
        view.ViewMain.setCustomersTxtPhone("");
        view.ViewMain.setCustomersTxtSearch("");
        loadCustomer();
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
