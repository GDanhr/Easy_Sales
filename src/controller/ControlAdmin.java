package controller;

import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DB;
import model.Employee;

public class ControlAdmin {

    private String name = view.ViewMain.getAdminTxtName().getText().trim();
    private String lastname = view.ViewMain.getAdminTxtLastname().getText().trim();
    private String email = view.ViewMain.getAdminTxtEmail().getText().trim();
    private String phone = view.ViewMain.getAdminTxtPhone().getText().trim();
    private JComboBox job = view.ViewMain.getAdminJobTitleList();
//    private String job = view.ViewMain.getAdminJobTitleList().getItemAt(0);
//    private int rank = view.ViewMain.getAdminJobTitleList().getSelectedIndex();
    private DB esql = new DB();
    private Employee employee = new Employee();
    JTable table = view.ViewMain.getAdminTable();

    public byte addAdmin() {
        if (name.isEmpty() && lastname.isEmpty() && email.isEmpty() && phone.isEmpty()) {
            // Ignore
            return 6;
        } else if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert name", "Error", JOptionPane.PLAIN_MESSAGE);
            return 1;
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert lastname", "Error", JOptionPane.PLAIN_MESSAGE);
            return 2;
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Insert email", "Error", JOptionPane.PLAIN_MESSAGE);
            return 3;
        } else if (phone.isEmpty() || !isNumeric(phone)) {
            JOptionPane.showMessageDialog(null, "Insert valid phone numer (only integers)", "Error", JOptionPane.PLAIN_MESSAGE);
            return 4;
        } else if (!(name.isEmpty() && lastname.isEmpty() && email.isEmpty() && phone.isEmpty())) {

            int Phone = Integer.parseInt(phone);
            String job = view.ViewMain.getAdminJobTitleList().getSelectedItem().toString();
            int rank = view.ViewMain.getAdminJobTitleList().getSelectedIndex();
            employee.setEmployee_Name(name);
            employee.setEmployee_Lastname(lastname);
            employee.setEmployee_Email(email);
            employee.setEmployee_phone(Phone);
            employee.setEmployee_Jobtitle(job);
            employee.setEmployee_Rank(rank);

            if (esql.newAdmin(employee)) {
                if (esql.addAdmin(employee)) {
                    JOptionPane.showMessageDialog(null, "User added");
                    Clear();
                    return 5;
                }
            } else {
                JOptionPane.showMessageDialog(null, "This user is already registered", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
        return 0;
    }

    public void updateAdmin() {
        if (table.getSelectedRow() >= 0) {
            if (!(name.isEmpty() && lastname.isEmpty() && email.isEmpty() && phone.isEmpty()) && isNumeric(phone)) {
                String ask = "Are you sure you want overwrite the information of this user?";
                int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    int Phone = Integer.parseInt(phone);
                    int row = table.getSelectedRow();
                    int ID = Integer.parseInt(table.getValueAt(row, 0).toString());
                    String job = view.ViewMain.getAdminJobTitleList().getSelectedItem().toString();
                    int rank = view.ViewMain.getAdminJobTitleList().getSelectedIndex();

                    employee.setEmployee_ID(ID);
                    employee.setEmployee_Name(name);
                    employee.setEmployee_Lastname(lastname);
                    employee.setEmployee_Email(email);
                    employee.setEmployee_phone(Phone);
                    employee.setEmployee_Jobtitle(job);
                    employee.setEmployee_Rank(rank);

                    if (esql.updateAdmin(employee)) {
                        JOptionPane.showMessageDialog(null, "User updated");
                        Clear();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the user in the table", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void deleteAdmin() {
        if (table.getSelectedRow() >= 0) {
            String ask = "Are you sure you want to delete the user: " + name + lastname + " ?";
            int answer = JOptionPane.showConfirmDialog(null, ask, "Confirm action", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                int row = table.getSelectedRow();
                int ID = Integer.parseInt(table.getValueAt(row, 0).toString());

                employee.setEmployee_ID(ID);

                esql.removeAdmin(employee);
                JOptionPane.showMessageDialog(null, "User deleted");
                Clear();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select the user in the table", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void loadAdminTable() {
        esql.adminTable(table);
        view.ViewMain.setAdminTable(table);
    }

    public void searchAdmin(){//Simple searcher, need to have only one name and lastname, can be improved.
        String searchText = view.ViewMain.getAdminTxtSearch().getText().trim();
        if (!searchText.isEmpty()) {
            if (isNumeric(searchText)) {
                esql.searchAdminTableById(table, Integer.parseInt(searchText));
            } else {
                if (isSpaced(searchText)) {
                    String Name = "";
                    String Lastname = "";
                    for (int i = 0; i < searchText.length(); i++) {
                        if (searchText.charAt(i) == ' ') {
                            Name = searchText.substring(0, i);
                            Lastname = searchText.substring(i + 1);
                        }
                    }
                    esql.searchAdminTableByNameAndLastname(table, Name, Lastname);
                } else {
                    esql.searchAdminTableByNameOrLastname(table, searchText);
                }
            }
        }
    }

    public void mouseClickedAdmin() {
        try {
            int row = table.getSelectedRow();

            String Name = table.getValueAt(row, 1).toString();
            String Lastname = table.getValueAt(row, 2).toString();
            String Email = table.getValueAt(row, 3).toString();
            String Phone = table.getValueAt(row, 4).toString();
            String Job = table.getValueAt(row, 5).toString();

            job.setSelectedItem(Job);
            view.ViewMain.setAdminTxtName(Name);
            view.ViewMain.setAdminTxtLastname(Lastname);
            view.ViewMain.setAdminTxtEmail(Email);
            view.ViewMain.setAdminTxtPhone(Phone);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void Clear()  {
        view.ViewMain.setAdminTxtName("");
        view.ViewMain.setAdminTxtLastname("");
        view.ViewMain.setAdminTxtEmail("");
        view.ViewMain.setAdminTxtPhone("");
        view.ViewMain.setAdminTxtSearch("");
        loadAdminTable();
    }

    private boolean isSpaced(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                return true;
            }
        }
        return false;
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
