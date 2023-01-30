package model;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class DB {

    String url = "jdbc:mysql://localhost/ezsales?useSSL=false&allowPublicKeyRetrieval=true";
    String user_DB = "root";
    String password_DB = "dani123";

    public DB() {

    }

    //Suppliers
    public boolean addSupplier(Supplier sup) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO suppliers(`supplierName`,`document`,`documentNumber`,`phone`)values(?,?,?,?)");) {
            ps.setString(1, sup.getName());
            ps.setString(2, sup.getDocType());
            ps.setInt(3, sup.getDocNum());
            ps.setInt(4, sup.getPhone());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean newSupplier(String supName) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT count(supplierId) FROM suppliers WHERE supplierName ='" + supName + "'");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean updateSupplier(Supplier sup) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("UPDATE `suppliers` SET `supplierName`=?,`document`=?,`documentNumber`=?,`phone`=? WHERE `supplierId` =?");) {
            ps.setString(1, sup.getName());
            ps.setString(2, sup.getDocType());
            ps.setInt(3, sup.getDocNum());
            ps.setInt(4, sup.getPhone());
            ps.setInt(5, sup.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void removeSupplier(String supName) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("DELETE FROM `suppliers` WHERE `supplierName` = '" + supName + "'");) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void suppliersInfoTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT * FROM suppliers");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Document Type", "Document Num", "Phone"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void searchSuppliersTable(JTable table, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `supplierId`,`supplierName`,`document`,`documentNumber`,`phone` FROM suppliers WHERE supplierName LIKE '%" + name + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Document Type", "Document Num", "Phone"};
                model.setColumnIdentifiers(columnNames);
            }
            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchSuppliersTable(JTable table, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            table.setModel(model);
            String sql = "SELECT `supplierId`,`supplierName`,`document`,`documentNumber`,`phone` FROM suppliers WHERE (supplierId = '" + id + "')";
            String sql2 = "SELECT `supplierId`,`supplierName`,`document`,`documentNumber`,`phone` FROM suppliers WHERE supplierId LIKE '%" + id + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int x = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Document Type", "Document Num", "Phone"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    x++;
                }
                model.addRow(rows);
            }
            if (x == 0) {
                ps = con.prepareStatement(sql2);
                rs = ps.executeQuery();

                rsMd = rs.getMetaData();
                columnCount = rsMd.getColumnCount();

                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"ID", "Name", "Document Type", "Document Num", "Phone"};
                    model.setColumnIdentifiers(columnNames);
                }

                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                        x++;
                    }
                    model.addRow(rows);
                }
            }
            return x == 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    //End of suppliers
    // Purchased items
    public void buyItem(PurchaseItem item) {
        PreparedStatement ps = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            ps = con.prepareStatement("INSERT INTO `purchase_items`(`name`,`supplier`,`quantity`)VALUES(?,?,?)");
            Timestamp tsldt = Timestamp.valueOf(LocalDateTime.now());

            ps.setString(1, item.getName());
            ps.setString(2, item.getSupplier());
            ps.setInt(3, item.getQty());

            ps.executeUpdate();

            ps = con.prepareStatement("INSERT INTO `purchase_items_order`(`name`,`quantity`,`price`,`date`) VALUES (?,?,?,?)");

            ps.setString(1, item.getName());
            ps.setInt(2, item.getQty());
            ps.setFloat(3, item.getTotal_cost());
            ps.setTimestamp(4, tsldt);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean newItemPurchase(String itemName) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT count(id) FROM purchase_items WHERE name ='" + itemName + "'");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void buyMoreItems(PurchaseItem item, int qty) {
        PreparedStatement ps = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            Timestamp tsldt = Timestamp.valueOf(LocalDateTime.now());
            ps = con.prepareStatement("UPDATE `purchase_items` SET `quantity` = `quantity` + '" + qty + "' WHERE `name` = '" + item.getName() + "'");
            ps.executeUpdate();

            ps = con.prepareStatement("INSERT INTO `purchase_items_order`(`name`,`quantity`,`price`,`date`) VALUES (?,?,?,?)");
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQty());
            ps.setFloat(3, item.getTotal_cost());
            ps.setTimestamp(4, tsldt);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public void itemPurchasedTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name`,`supplier`,`quantity` FROM `purchase_items`");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Name", "Supplier", "Stock"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void loadItemPurchasedList(JComboBox list) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `items`");
                ResultSet rs = ps.executeQuery();) {
            list.removeAllItems();
            list.addItem("--");
            while (rs.next()) {
                list.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void loadItemPurchasedSupplierList(JComboBox list) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `supplierName` FROM `suppliers`");
                ResultSet rs = ps.executeQuery();) {
            list.removeAllItems();
            list.addItem("--");
            while (rs.next()) {
                list.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void searchItemPurchasedTable(JTable table, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name`,`supplier`,`quantity` FROM `purchase_items` WHERE `name` LIKE '%" + name + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Name", "Supplier", "Stock"};
                model.setColumnIdentifiers(columnNames);
            }
            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    // end of purchased items

    //Item
    public void addItem(Item item) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("insert into items(`name`,`measure`)values('" + item.getName() + "','" + item.getUnit() + "')");) {
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public boolean newItem(String itemName) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(id) FROM items WHERE name ='" + itemName + "'");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void itemsTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT * FROM items");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Unit measure"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void searchItemTable(JTable table, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `id`,`name`,`measure` FROM items WHERE name LIKE '%" + name + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Unit measure"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchItemTable(JTable table, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            table.setModel(model);
            String sql = "SELECT `id`,`name`,`measure` FROM items WHERE (`id` ='" + id + "')";
            String sql2 = "SELECT `id`,`name`,`measure` FROM items WHERE `id` LIKE '%" + id + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int x = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Unit measure"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    x++;
                }
                model.addRow(rows);
            }
            if (x == 0) {
                ps = con.prepareStatement(sql2);
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();
                columnCount = rsMd.getColumnCount();

                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"ID", "Name", "Unit measure"};
                    model.setColumnIdentifiers(columnNames);
                }
                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                        x++;
                    }
                    model.addRow(rows);
                }
            }
            return x == 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean updateItem(Item item, String name) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            ps = con.prepareStatement("SELECT `id` FROM `items` WHERE `name`='" + name + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt(1));
                String sql2 = "UPDATE `items` SET `name`=?,`measure`=? WHERE (`id`= '" + item.getId() + "')";
                ps = con.prepareStatement(sql2);
                ps.setString(1, item.getName());
                ps.setString(2, item.getUnit());
                ps.executeUpdate();
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
    }

    public void removeItem(String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE name = '" + name + "'");) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    //end of items

    //ProductLines
    public void addLine(ProductLine pl) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO product_lines(`productLine`)VALUES('" + pl.getProductLine_Name() + "')");) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public boolean newLine(String lineName) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(productLineId) FROM product_lines WHERE productLine ='" + lineName + "'");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void productLineTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT * FROM product_lines");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Product line"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean updateLine(ProductLine pl, String name) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            ps = con.prepareStatement("SELECT `productLineId` FROM `product_lines` WHERE (`productLine`='" + name + "')");
            rs = ps.executeQuery();
            while (rs.next()) {
                pl.setProductLine_Id(rs.getInt(1));
                String sql2 = "UPDATE `product_lines` SET `productLine`=? WHERE (`productLineId`= '" + pl.getProductLine_Id() + "')";
                ps = con.prepareStatement(sql2);
                ps.setString(1, pl.getProductLine_Name());
                ps.executeUpdate();
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
    }

    public void searchProductLineTable(JTable table, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `productLineId`,`productLine` FROM product_lines WHERE productLine LIKE '%" + name + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Product line"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchProductLineTable(JTable table, int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            table.setModel(model);
            ps = con.prepareStatement("SELECT `productLineId`,`productLine` FROM product_lines WHERE (`productLineId` = '" + id + "')");
            String sql2 = "SELECT `productLineId`,`productLine` FROM product_lines WHERE `productLineId` LIKE '%" + id + "%'";
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int x = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Product line"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    x++;
                }
                model.addRow(rows);
            }
            if (x == 0) {
                ps = con.prepareStatement(sql2);
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();
                columnCount = rsMd.getColumnCount();

                if (model.getColumnCount() <= 0) {
                    model.addColumn("ID");
                    model.addColumn("Product line");
                }

                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                        x++;
                    }
                    model.addRow(rows);
                }
            }
            return x == 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
    }

    public void removeLine(String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("DELETE FROM product_lines WHERE productLine = '" + name + "'");) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    //end of productLines

    //Products
    public boolean addProduct(Product prod) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO products(`code`,`name`,`price`,`Qty`,`productLine`,`item`)VALUES(?,?,?,?,?,?)");) {
            ps.setInt(1, prod.getCode());
            ps.setString(2, prod.getName());
            ps.setFloat(3, prod.getPrice());
            ps.setInt(4, prod.getQty());
            ps.setString(5, prod.getLine());
            ps.setString(6, prod.getItems());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean newProduct(Product prod) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(id) FROM products WHERE code ='" + prod.getCode() + "'");
                ResultSet rs = ps.executeQuery();) {
            return (rs.next() && rs.getInt(1) == 0);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void searchProductTable(JTable table, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `code`,`name`,`price`,`Qty`=?,`productLine`,`item` FROM `products` WHERE name LIKE '%" + name + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Code", "Name", "Price", "Stock", "Product line", "Items"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchProductTable(JTable table, int code) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            table.setModel(model);
            String sql = "SELECT `code`,`name`,`price`,`Qty`,`productLine`,`item` FROM `products` WHERE (`code` = '" + code + "')";
            String sql2 = "SELECT `code`,`name`,`price`,`Qty`,`productLine`,`item` FROM `products` WHERE `code` LIKE '%" + code + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int x = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Code", "Name", "Price", "Stock", "Product line", "Items"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    x++;
                }
                model.addRow(rows);
            }
            if (x == 0) {
                ps = con.prepareStatement(sql2);
                rs = ps.executeQuery();
                rsMd = rs.getMetaData();
                columnCount = rsMd.getColumnCount();

                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"Code", "Name", "Price", "Stock", "Product line", "Items"};
                    model.setColumnIdentifiers(columnNames);
                }

                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                        x++;
                    }
                    model.addRow(rows);
                }
            }
            return x == 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean removeProduct(int code) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE `code` = '" + code + "'");) {
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void loadProductLines(JComboBox c) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `productLine` FROM `product_lines`");
                ResultSet rs = ps.executeQuery();) {
            c.removeAllItems();
            c.addItem("--");
            while (rs.next()) {
                c.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void loadItems(JComboBox c) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `purchase_items` WHERE (`quantity` > '0')");
                ResultSet rs = ps.executeQuery();) {
            c.removeAllItems();
            c.addItem("--");
            while (rs.next()) {
                c.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public String loadItemList(String list, int id) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `item` FROM `products` WHERE (`id` ='" + id + "')");
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                list = rs.getString(1);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return list;
        }
    }

    public JTable productsTable() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            int rowCount = 0;
            String sql = "SELECT `id`,`code`,`name`,`price`,`Qty`,`productLine`,`item` FROM `products`";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            List<String[]> rowss = new ArrayList<>();

            /*Aqui le asigno los valores de la base de datos al vector*/
            for (int i = 0; rs.next(); i++) {
                String[] rows = new String[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    rows[j] = rs.getObject(j + 1).toString();
                }
                rowCount++;
                rowss.add(rows);
            }

            /*Aqui vuelvo a ejecutar el query para asignarle los valores a la matriz*/
            String[] columnNames = {"ID", "Code", "Name", "Price", "Qty", "Product line", "Items"};
            String[][] data = new String[rowCount][columnNames.length];
            rs = ps.executeQuery();
            for (int i = 0; rs.next(); i++) {
                for (int j = 0; j < columnCount; j++) {
                    if (j == columnCount - 1) {
                        data[i][j] = "Click to see";
                    } else {
                        data[i][j] = rs.getObject(j + 1).toString();
                    }
                }
            }

            /*Aqui comienzo a crear los combobox y el celleditor*/
            String itemListInString;
            List<TableCellEditor> editors = new ArrayList<>();
            for (int j = 0; j < rowss.size(); j++) {
                Object[] itemList = rowss.get(j);
                itemListInString = itemList[6].toString();

                JComboBox<String> c = new JComboBox<>();
                List<String> al = new ArrayList<>();

                /*Aqui separo los String cada que encuentra un ";" y añado los elementos al combobox y el combobox al celleditor*/
                for (int i = 0; i < itemListInString.length(); i++) {
                    if (itemListInString.charAt(i) == ';') {
                        al.add(itemListInString.substring(0, i));
                        itemListInString = itemListInString.substring(i + 1);
                        i = 0;
                    } else if (i == itemListInString.length() - 1 && itemListInString.length() > 0) {
                        al.add(itemListInString.substring(0, i + 1));
                    }
                }
                for (int i = 0; i < al.size(); i++) {
                    c.addItem(al.get(i));
                }
                editors.add(new DefaultCellEditor(c));
            }

            /*Aqui sobreescribo los metodos del defaulttablemodel para que no se puedan editar y la columna items sea combobox*/
            final int finalRowCount = rowCount;
            final int finalColumnCount = columnCount;
            DefaultTableModel model1 = new DefaultTableModel(data, columnNames);
            JTable newTable = new JTable(model1) {
                @Override
                public TableCellEditor getCellEditor(int row, int column) {

                    int modelColumn = convertColumnIndexToModel(column);
                    if (modelColumn == finalColumnCount - 1 && row < finalRowCount) {
                        return editors.get(row);

                    } else {
                        return super.getCellEditor(row, column);
                    }
                }
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, true
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            newTable.setName("ProductsPane2Table");
            return newTable;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public JTable searchProductsTable(String type, int id_code) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            int rowCount = 0;
            String sql = "";
            if (type.equals("id")) {
                sql = "SELECT `id`,`code`,`name`,`price`,`Qty`,`productLine`,`item` FROM `products` WHERE (`id` ='" + id_code + "')";
            } else if (type.equals("code")) {
                sql = "SELECT `id`,`code`,`name`,`price`,`Qty`,`productLine`,`item` FROM `products` WHERE (`code` ='" + id_code + "')";
            }
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            List<String[]> rowss = new ArrayList<>();

            /*Aqui le asigno los valores de la base de datos al vector*/
            for (int i = 0; rs.next(); i++) {
                String[] rows = new String[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    rows[j] = rs.getObject(j + 1).toString();
                }
                rowCount++;
                rowss.add(rows);
            }

            /*Aqui vuelvo a ejecutar el query para asignarle los valores a la matriz*/
            String[] columnNames = {"ID", "Code", "Name", "Price", "Stock", "Product line", "Items"};
            String[][] data = new String[rowCount][columnNames.length];
            rs = ps.executeQuery();
            for (int i = 0; rs.next(); i++) {
                for (int j = 0; j < columnCount; j++) {
                    if (j == columnCount - 1) {
                        data[i][j] = "Click to see";
                    } else {
                        data[i][j] = rs.getObject(j + 1).toString();
                    }
                }
            }

            /*Aqui comienzo a crear los combobox y el celleditor*/
            String itemListInString;
            List<TableCellEditor> editors = new ArrayList<>();
            for (int j = 0; j < rowss.size(); j++) {
                Object[] itemList = rowss.get(j);
                itemListInString = itemList[6].toString();

                JComboBox<String> c = new JComboBox<>();
                List<String> al = new ArrayList<>();

                /*Aqui separo los String cada que encuentra un ";" y añado los elementos al combobox y el combobox al celleditor*/
                for (int i = 0; i < itemListInString.length(); i++) {
                    if (itemListInString.charAt(i) == ';') {
                        al.add(itemListInString.substring(0, i));
                        itemListInString = itemListInString.substring(i + 1);
                        i = 0;
                    } else if (i == itemListInString.length() - 1 && itemListInString.length() > 0) {
                        al.add(itemListInString.substring(0, i + 1));
                    }
                }
                for (int i = 0; i < al.size(); i++) {
                    c.addItem(al.get(i));
                }
                editors.add(new DefaultCellEditor(c));
            }

            /*Aqui sobreescribo los metodos del defaulttablemodel para que no se puedan editar y la columna items sea combobox*/
            final int finalRowCount = rowCount;
            final int finalColumnCount = columnCount;
            DefaultTableModel model1 = new DefaultTableModel(data, columnNames);
            JTable newTable = new JTable(model1) {
                @Override
                public TableCellEditor getCellEditor(int row, int column) {

                    int modelColumn = convertColumnIndexToModel(column);
                    if (modelColumn == finalColumnCount - 1 && row < finalRowCount) {
                        return editors.get(row);

                    } else {
                        return super.getCellEditor(row, column);
                    }
                }
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, true
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            };
            newTable.setName("ProductsPane2Table");
            return newTable;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean searchProductsTableById(int id) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(id) FROM `products` WHERE (`id` ='" + id + "')");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 1;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean searchProductsTableByCode(int code) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(id) FROM `products` WHERE (`code` ='" + code + "')");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 1;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    //end of products
    //customers
    public boolean addCustomer(Customer c) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO customers(`customerDocumentId`,`customerFirstName`,`customerLastName`,`email`,`phone`)VALUES(?,?,?,?,?)");) {
            ps.setInt(1, c.getCustomer_Document_Id());
            ps.setString(2, c.getCustomer_Name());
            ps.setString(3, c.getCustomer_Lastname());
            ps.setString(4, c.getCustomer_email());
            ps.setInt(5, c.getCustomer_Phone());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean newCustomer(int DocID) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(customerId) FROM customers WHERE (`customerDocumentId` ='" + DocID + "')");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean updateCustomer(Customer c) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("UPDATE `customers` SET `customerFirstName`=?,`customerLastName`=?,`email`=?,`phone`=? WHERE `customerId` =?");) {
            ps.setString(1, c.getCustomer_Name());
            ps.setString(2, c.getCustomer_Lastname());
            ps.setString(3, c.getCustomer_email());
            ps.setInt(4, c.getCustomer_Phone());
            ps.setInt(5, c.getCustomer_Id());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void removeCustomer(int id) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("DELETE FROM `customers` WHERE `customerId` = '" + id + "'");) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void customersTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT * FROM customers");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Document ID", "Name", "Lastname", "Email", "Phone"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchCustomerTable(JTable table, int DocID) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `customerId`,`customerDocumentId`,`customerFirstName`,`customerLastName`,`email`,`phone` FROM customers WHERE customerDocumentId LIKE '%" + DocID + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int count = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Document ID", "Name", "Lastname", "Email", "Phone"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
                count++;
            }
            return count != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean searchCustomerTable(JTable table, String name, boolean type) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            table.setModel(model);
            String sql = "";
            if (type) {//true = customerName
                sql = "SELECT `customerId`,`customerDocumentId`,`customerFirstName`,`customerLastName`,`email`,`phone` FROM customers WHERE customerFirstName LIKE '%" + name + "%'";
            } else {//false = customerLastname
                sql = "SELECT `customerId`,`customerDocumentId`,`customerFirstName`,`customerLastName`,`email`,`phone` FROM customers WHERE customerLastName LIKE '%" + name + "%'";
            }

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int count = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Document ID", "Name", "Lastname", "Email", "Phone"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                count++;
                model.addRow(rows);
            }
            return count != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    //end of customers
    //Admin
    public boolean addAdmin(Employee e) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO employees(`firstName`,`lastName`,`email`,`phone`,`jobTitle`,`rank`)VALUES(?,?,?,?,?,?)");) {
            ps.setString(1, e.getEmployee_Name());
            ps.setString(2, e.getEmployee_Lastname());
            ps.setString(3, e.getEmployee_Email());
            ps.setInt(4, e.getEmployee_phone());
            ps.setString(5, e.getEmployee_Jobtitle());
            ps.setInt(6, e.getEmployee_Rank());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean newAdmin(Employee e) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT COUNT(employeeId) FROM employees WHERE firstName ='" + e.getEmployee_Name() + "' AND lastName = '" + e.getEmployee_Lastname() + "' AND email ='" + e.getEmployee_Email() + "' AND phone = '" + e.getEmployee_phone() + "'");
                ResultSet rs = ps.executeQuery();) {
            return rs.next() && rs.getInt(1) == 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean updateAdmin(Employee e) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("UPDATE `employees` SET `firstName`=?,`lastName`=?,`email`=?,`phone`=?,`jobTitle`=? WHERE `employeeId` =?");) {
            ps.setString(1, e.getEmployee_Name());
            ps.setString(2, e.getEmployee_Lastname());
            ps.setString(3, e.getEmployee_Email());
            ps.setInt(4, e.getEmployee_phone());
            ps.setString(5, e.getEmployee_Jobtitle());
            ps.setInt(6, e.getEmployee_ID());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void removeAdmin(Employee e) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("DELETE FROM `employees` WHERE `employeeId` = '" + e.getEmployee_ID() + "'");) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void adminTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `employeeId`,`firstName`,`lastName`,`email`,`phone`,`jobTitle` FROM employees");
                ResultSet rs = ps.executeQuery();) {

            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Lastname", "Email", "Phone", "Job"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchAdminTableById(JTable table, int id) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `employeeId`,`firstName`,`lastName`,`email`,`phone`,`jobTitle` FROM employees WHERE (`employeeId` = '" + id + "')");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            String sql2 = "SELECT `employeeId`,`firstName`,`lastName`,`email`,`phone`,`jobTitle` FROM employees WHERE `employeeId` LIKE '%" + id + "%'";

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int x = 0;

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Lastname", "Email", "Phone", "Job"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    x++;
                }
                model.addRow(rows);
            }
            if (x == 0) {
                PreparedStatement pst = con.prepareStatement(sql2);
                ResultSet res = pst.executeQuery();
                rsMd = res.getMetaData();
                columnCount = rsMd.getColumnCount();

                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"ID", "Name", "Lastname", "Email", "Phone", "Job"};
                    model.setColumnIdentifiers(columnNames);
                }

                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                        x++;
                    }
                    model.addRow(rows);
                }
            }
            return x == 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean searchAdminTableByNameAndLastname(JTable table, String name, String lastname) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `employeeId`,`firstName`,`lastName`,`email`,`phone`,`jobTitle` FROM employees WHERE `firstName` = '" + name + "' AND `lastName` = '" + lastname + "'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            int count = 0;
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Lastname", "Email", "Phone", "Job"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    count++;
                }
                model.addRow(rows);
            }
            return count != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean searchAdminTableByNameOrLastname(JTable table, String user) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `employeeId`,`firstName`,`lastName`,`email`,`phone`,`jobTitle` FROM employees WHERE `firstName` = '" + user + "'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            String sql2 = "SELECT `employeeId`,`firstName`,`lastName`,`email`,`phone`,`jobTitle` FROM employees WHERE `lastName` = '" + user + "'";
            int count = 0;
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Name", "Lastname", "Email", "Phone", "Job"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    count++;
                }
                model.addRow(rows);
            }
            if (count == 0) {
                PreparedStatement pst = con.prepareStatement(sql2);
                ResultSet res = pst.executeQuery();

                rsMd = res.getMetaData();
                columnCount = rsMd.getColumnCount();

                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"ID", "Name", "Lastname", "Email", "Phone", "Job"};
                    model.setColumnIdentifiers(columnNames);
                }

                while (res.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                        count++;
                    }
                    model.addRow(rows);
                }
            }
            return count != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    //End of Admin

    //Reports
    public void loadReportsSalesTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement(
                        "SELECT `firstName`,`lastName`,`customerFirstName`,`customerLastName`,`customerDocumentId`,`final_cost`,`date` FROM `order` "
                      + "INNER JOIN `customers` ON `order`.`customer` = `customers`.`customerId` "
                      + "INNER JOIN `employees` ON `order`.`employee` = `employees`.`employeeId`");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Employee", "Customer", "Customer Doc ID", "Final price","Date"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                rows[0] = rs.getObject(1) + "  " + rs.getObject(2);
                rows[1] = rs.getObject(3) + "  " + rs.getObject(4);
                rows[2] = rs.getObject(5);
                rows[3] = rs.getObject(6);
                rows[4] = rs.getObject(7).toString().substring(0, 11);
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void loadReportsPurchasesTable(JTable table){
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement(
                        "SELECT `purchase_items`.`name`,`supplier`,`purchase_items`.`quantity`,`price`,`date` "
                      + "FROM `purchase_items` INNER JOIN `purchase_items_order` ON `purchase_items`.`name` = `purchase_items_order`.`name`; ");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Item", "Supplier", "Stock", "Cost","Date"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                rows[0] = rs.getObject(1);
                rows[1] = rs.getObject(2);
                rows[2] = rs.getObject(3);
                rows[3] = rs.getObject(4);
                rows[4] = rs.getObject(5).toString().substring(0, 11);
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void loadReportsSalesTable(JTable table,String date) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement(
                        "SELECT `firstName`,`lastName`,`customerFirstName`,`customerLastName`,`customerDocumentId`,`final_cost`,`date` FROM `order` "
                      + "INNER JOIN `customers` ON `order`.`customer` = `customers`.`customerId` "
                      + "INNER JOIN `employees` ON `order`.`employee` = `employees`.`employeeId`"
                      + "WHERE `order`.`date` >= '" + date + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Employee", "Customer", "Customer Doc ID", "Final price","Date"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                rows[0] = rs.getObject(1) + "  " + rs.getObject(2);
                rows[1] = rs.getObject(3) + "  " + rs.getObject(4);
                rows[2] = rs.getObject(5);
                rows[3] = rs.getObject(6);
                rows[4] = rs.getObject(7).toString().substring(0, 11);
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void loadReportsPurchasesTable(JTable table,String date){
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement(
                        "SELECT `purchase_items`.`name`,`supplier`,`purchase_items`.`quantity`,`price`,`date` "
                      + "FROM `purchase_items` INNER JOIN `purchase_items_order` ON `purchase_items`.`name` = `purchase_items_order`.`name`"
                      + " WHERE `purchase_items_order`.`date` >= '" + date + "%'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Item", "Supplier", "Stock", "Cost","Date"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                rows[0] = rs.getObject(1);
                rows[1] = rs.getObject(2);
                rows[2] = rs.getObject(3);
                rows[3] = rs.getObject(4);
                rows[4] = rs.getObject(5).toString().substring(0, 11);
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void loadReportsSalesTable(JTable table,String dateFrom,String dateTo) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement(
                        "SELECT `firstName`,`lastName`,`customerFirstName`,`customerLastName`,`customerDocumentId`,`final_cost`,`date` FROM `order` "
                      + "INNER JOIN `customers` ON `order`.`customer` = `customers`.`customerId` "
                      + "INNER JOIN `employees` ON `order`.`employee` = `employees`.`employeeId`"
                      + "WHERE `order`.`date` BETWEEN '" + dateFrom + "%' AND '" + dateTo +"'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Employee", "Customer", "Customer Doc ID", "Final price","Date"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                rows[0] = rs.getObject(1) + "  " + rs.getObject(2);
                rows[1] = rs.getObject(3) + "  " + rs.getObject(4);
                rows[2] = rs.getObject(5);
                rows[3] = rs.getObject(6);
                rows[4] = rs.getObject(7).toString().substring(0, 11);
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void loadReportsPurchasesTable(JTable table,String dateFrom,String dateTo){
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement(
                        "SELECT `purchase_items`.`name`,`supplier`,`purchase_items`.`quantity`,`price`,`date` "
                      + "FROM `purchase_items` INNER JOIN `purchase_items_order` ON `purchase_items`.`name` = `purchase_items_order`.`name`"
                      + " WHERE `purchase_items_order`.`date` BETWEEN '" + dateFrom + "%' AND '" + dateTo + "'");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"Item", "Supplier", "Stock", "Cost","Date"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                rows[0] = rs.getObject(1);
                rows[1] = rs.getObject(2);
                rows[2] = rs.getObject(3);
                rows[3] = rs.getObject(4);
                rows[4] = rs.getObject(5).toString().substring(0, 11);
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //End of reports
    //Sales
    public boolean searchSaleProductsTable(JTable table, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `id`,`code`,`name`,`price`,`Qty`,`productLine` FROM `products` WHERE (`name` ='" + name + "')");
                ResultSet rs = ps.executeQuery();) {
            DefaultTableModel newModel = (DefaultTableModel) table.getModel();
            if (newModel.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Code", "Name", "Price", "On stock", "Product line"};
                newModel.setColumnIdentifiers(columnNames);
            }

            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();
            int x = 0;

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                    x++;
                }
                newModel.addRow(rows);
            }
            return x != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void searchSaleProductsList(JList list, int code) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `products` WHERE `id` LIKE '%" + code + "%'");
                ResultSet rs = ps.executeQuery();) {
            DefaultListModel modelist = new DefaultListModel();
            int x = 0;
            while (rs.next()) {
                modelist.addElement(rs.getString(1));
                x++;
            }
            list.setModel(modelist);
            if (x == 0) {
                String sql2 = "SELECT `name` FROM `products` WHERE `code` LIKE '%" + code + "%'";
                var pst = con.prepareStatement(sql2);
                var res = pst.executeQuery();
                while (rs.next()) {
                    modelist.addElement(res.getString(1));
                }
                list.setModel(modelist);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void searchSaleProductsList(JList list, String name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `products` WHERE `name` LIKE '%" + name + "%'");
                ResultSet rs = ps.executeQuery();) {
            DefaultListModel modelist = new DefaultListModel();
            while (rs.next()) {
                modelist.addElement(rs.getString(1));
            }
            list.setModel(modelist);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void loadSaleComboBox(JComboBox c) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `products` WHERE (`Qty` > 0)");
                ResultSet rs = ps.executeQuery();) {
            c.removeAllItems();
            c.addItem("--");
            while (rs.next()) {
                c.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void searchSaleCustomer(int id, JLabel name) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `customerFirstName`,`customerLastName` FROM `customers` WHERE `customerDocumentId` = '" + id + "'");
                ResultSet rs = ps.executeQuery();) {
            String fullName = "";
            while (rs.next()) {
                fullName += rs.getString(1) + " " + rs.getString(2);
            }
            name.setText(fullName);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void addSale(Sale sale) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO `order`(`products`,`cost`,`final_cost`,`discount`,`customer`,`employee`,`date`)VALUES(?,?,?,?,?,?,?)");) {
            Timestamp tsldt = Timestamp.valueOf(LocalDateTime.now());

            ps.setString(1, sale.getProducts());
            ps.setFloat(2, sale.getCost());
            ps.setFloat(3, sale.getFinal_cost());
            ps.setString(4, sale.getDiscount());
            ps.setInt(5, sale.getCustomer());
            ps.setInt(6, sale.getEmployee());
            ps.setTimestamp(7, tsldt);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void updateProductsAfterSale(ArrayList prods, ArrayList qty) {
        PreparedStatement ps = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            for (int i = 0; i < prods.size(); i++) {
                ps = con.prepareStatement("UPDATE `products` SET `Qty`=(`Qty` - '" + qty.get(i) + "') WHERE `name` = '" + prods.get(i) + "'");
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    //End of Sales
    //Login-Register
    public boolean login(Employee user) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `employeeId`,`firstName`,`lastName`,`rank`,`Password` FROM `employees` WHERE (`User` ='" + user.getEmployee_user() + "')");
                ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                if (user.getEmployee_password().equals(rs.getString(5))) {

                    user.setEmployee_ID(rs.getInt(1));
                    user.setEmployee_Name(rs.getString(2));
                    user.setEmployee_Lastname(rs.getString(3));
                    user.setEmployee_Rank(rs.getInt(4));

                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
        return false;
    }

    public boolean newUser(String user) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT count(employeeId) FROM `employees` WHERE (`User` ='" + user + "')");
                ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public boolean registerUser(Employee user) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("INSERT INTO `employees`(`firstName`,`lastName`,`email`,`jobTitle`,`phone`,`User`,`Password`,`rank`)VALUES(?,?,?,?,?,?,?,?)");) {
            ps.setString(1, user.getEmployee_Name());
            ps.setString(2, user.getEmployee_Lastname());
            ps.setString(3, user.getEmployee_Email());
            ps.setString(4, user.getEmployee_Jobtitle());
            ps.setInt(5, user.getEmployee_phone());
            ps.setString(6, user.getEmployee_user());
            ps.setString(7, user.getEmployee_password());
            ps.setInt(8, user.getEmployee_Rank());

            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    //End of Login-Register
    //Product Stock
    public void loadProductStock(JComboBox list) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `products`");
                ResultSet rs = ps.executeQuery();) {

            list.removeAllItems();
            list.addItem("--");
            while (rs.next()) {
                list.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void addProductStock(ArrayList list, int id, int qty) {
        PreparedStatement ps = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            for (int i = 0; i < list.size() - 1; i += 2) {
                ps = con.prepareStatement("UPDATE `purchase_items` SET `quantity` = (`quantity` - '" + list.get(i) + "') WHERE (`name` = '" + list.get(i + 1) + "')");
                ps.executeUpdate();
            }
            ps = con.prepareStatement("UPDATE `products` SET `Qty` = (`Qty` + '" + qty + "') WHERE (`id` = '" + id + "')");
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void releaseItems(ArrayList list) {
        PreparedStatement ps = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            for (int i = 0; i < list.size() - 1; i += 2) {
                ps = con.prepareStatement("UPDATE `purchase_items` SET `quantity` = (`quantity` + '" + list.get(i) + "') WHERE (`name` = '" + list.get(i + 1) + "')");
                ps.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void updateStock(int id, int qty) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("UPDATE `products` SET `Qty` = (`Qty` - '" + qty + "') WHERE (`id` = '" + id + "')");) {
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean checkStock(ArrayList list) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            int problemCount = 0;
            for (int i = 0; i < list.size() - 1; i += 2) {
                ps = con.prepareStatement("SELECT `quantity` FROM `purchase_items` WHERE (`name` = '" + list.get(i + 1) + "')");
                rs = ps.executeQuery();
                boolean enoughStock = true;
                while (rs.next()) {
                    enoughStock = rs.getInt(1) > Integer.parseInt(list.get(i).toString());
                }
                if (!enoughStock) {
                    problemCount++;
                }
            }
            return problemCount == 0;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public void loadProductStockTable(JTable table) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `id`,`code`,`name`,`Qty` FROM `products`");
                ResultSet rs = ps.executeQuery();) {
            table.setModel(model);
            ResultSetMetaData rsMd = rs.getMetaData();
            int columnCount = rsMd.getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Code", "Name", "Stock"};
                model.setColumnIdentifiers(columnNames);
            }

            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public boolean searchProductStockNum(int id_code, JTable table) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            ps = con.prepareStatement("SELECT COUNT(id) FROM `products` WHERE (`id` = '" + id_code + "')");
            rs = ps.executeQuery();
            if (rs.next()) {
                ps = con.prepareStatement("SELECT `id`,`code`,`name`,`Qty` FROM `products` WHERE (`id` = '" + id_code + "')");
                rs = ps.executeQuery();
                table.setModel(model);
                int columnCount = rs.getMetaData().getColumnCount();
                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"ID", "Code", "Name", "Stock"};
                    model.setColumnIdentifiers(columnNames);
                }
                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                    }
                    model.addRow(rows);
                }
                return true;
            }
            ps = con.prepareStatement("SELECT COUNT(code) FROM `products` WHERE (`code` = '" + id_code + "')");
            rs = ps.executeQuery();
            if (rs.next()) {
                ps = con.prepareStatement("SELECT `id`,`code`,`name`,`Qty` FROM `products` WHERE (`code` = '" + id_code + "')");
                rs = ps.executeQuery();
                table.setModel(model);
                int columnCount = rs.getMetaData().getColumnCount();
                if (model.getColumnCount() <= 0) {
                    String[] columnNames = {"ID", "Code", "Name", "Stock"};
                    model.setColumnIdentifiers(columnNames);
                }
                while (rs.next()) {
                    Object[] rows = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rows[i] = rs.getObject(i + 1);
                    }
                    model.addRow(rows);
                }
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public void searchProductStockList(String name, JList list) {
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);
                PreparedStatement ps = con.prepareStatement("SELECT `name` FROM `products` WHERE (`name` LIKE '%" + name + "%')");
                ResultSet rs = ps.executeQuery();) {
            DefaultListModel modelist = new DefaultListModel();
            while (rs.next()) {
                modelist.addElement(rs.getString(1));
            }
            list.setModel(modelist);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void searchProductStockName(String name, JTable table) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection con = (Connection) DriverManager.getConnection(url, user_DB, password_DB);) {
            ps = con.prepareStatement("SELECT `id`,`code`,`name`,`Qty` FROM `products` WHERE (`name` = '" + name + "')");
            rs = ps.executeQuery();
            table.setModel(model);
            int columnCount = rs.getMetaData().getColumnCount();

            if (model.getColumnCount() <= 0) {
                String[] columnNames = {"ID", "Code", "Name", "Stock"};
                model.setColumnIdentifiers(columnNames);
            }
            while (rs.next()) {
                Object[] rows = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                model.addRow(rows);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    //End of Product Stock

    //variables
    DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    //end of variables
}
