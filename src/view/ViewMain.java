package view;

import com.toedter.calendar.JDateChooser;
import controller.TextPrompt;
import controller.ControlAdmin;
import controller.ControlCustomers;
import controller.ControlProductLine;
import controller.ControlProductStock;
import controller.ControlProducts;
import controller.ControlProductsItems;
import controller.ControlProductsTable;
import controller.ControlReports;
import controller.ControlSales;
import controller.ControlSuppliersInfo;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Employee;
import controller.ControlSuppliersItems;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class ViewMain extends javax.swing.JFrame {

    public ViewMain() {
        initComponents();
        myInitComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("EzSales");
        setSize(1300, 930);
    }

    public ViewMain(Employee user) {
        initComponents();
        myInitComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("EzSales");
        setSize(1300, 930);
        if (user.getEmployee_Rank() == 1) {
            panelProducts.removeTabAt(1);
            panelProducts.removeTabAt(1);
            panelProducts.removeTabAt(1);
            mainPanel.removeTabAt(3);
            mainPanel.removeTabAt(3);
            mainPanel.removeTabAt(3);
        }
        SaleTxtEmployeeID.setText(String.valueOf(user.getEmployee_ID()));
        SaleTxtEmployeeName.setText(user.getEmployee_Name() + " " + user.getEmployee_Lastname());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        salePanel = new javax.swing.JPanel();
        panelSalesTittle = new javax.swing.JPanel();
        lblTittleSales = new javax.swing.JLabel();
        SaleTxtEmployeeName = new javax.swing.JLabel();
        SaleTxtEmployeeID = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        panelSalesInfo = new javax.swing.JPanel();
        lblSaleDetails = new javax.swing.JLabel();
        lblProduct = new javax.swing.JLabel();
        SaleBtnDropProduct = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        SaleTxtDiscount = new javax.swing.JTextField();
        SaleTxtPrice = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SaleProductList = new javax.swing.JList<>();
        SaleBtnClearAll = new javax.swing.JButton();
        SaleDiscountType = new javax.swing.JComboBox<>();
        SaleProductCBox = new javax.swing.JComboBox<>();
        SaleBtnSearchProduct1 = new javax.swing.JButton();
        saleTxtProduct = new javax.swing.JTextField();
        saleBtnSearchProduct = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        saleSearchList = new javax.swing.JList<>();
        saleTxtQty = new javax.swing.JSpinner();
        panelSalesTable = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        SaleTableProduct = new javax.swing.JTable();
        panelSaleCustomer = new javax.swing.JPanel();
        lblCustomer = new javax.swing.JLabel();
        SaleBtnSearchCustomer = new javax.swing.JButton();
        SaleBtnClearCustomer = new javax.swing.JButton();
        SaleTxtCustomerId = new javax.swing.JTextField();
        lblProduct1 = new javax.swing.JLabel();
        SaleTxtCustomerName = new javax.swing.JLabel();
        lblProduct3 = new javax.swing.JLabel();
        panelSaleOperation = new javax.swing.JPanel();
        lblTotalCost = new javax.swing.JLabel();
        lblDollar = new javax.swing.JLabel();
        SaleTxtTotalCost = new javax.swing.JLabel();
        lblCustomerPay = new javax.swing.JLabel();
        SaleTxtCustomerPay = new javax.swing.JTextField();
        SaleBtnPay = new javax.swing.JButton();
        productPanel = new javax.swing.JPanel();
        panelProductsTittle = new javax.swing.JPanel();
        lblProducts = new javax.swing.JLabel();
        ProductsTxtSearch = new javax.swing.JTextField();
        ProductsBtnSearch = new javax.swing.JButton();
        panelProducts = new javax.swing.JTabbedPane();
        ProductsTablePanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ProductDetailsPanel = new javax.swing.JPanel();
        panelTableProductDetails = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        //DB esql = new DB();
        ProductsPane2Table = new JTable();
        panelProductDetailsOperation = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        ProductsPane2TxtProductCode = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        ProductsPane2ProductPrice = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        ProductsPane2BtnAdd = new javax.swing.JButton();
        ProductsPane2BtnDelete = new javax.swing.JButton();
        ProductsPane2TxtProductName = new javax.swing.JTextField();
        ProductsPane2ProductLine = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        ProductsPane2Item = new javax.swing.JComboBox<>();
        ProductsPane2AddItem = new javax.swing.JButton();
        ProductsPane2BtnRemoveItem = new javax.swing.JButton();
        ProductsPane2BtnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductsPane2ItemList = new javax.swing.JList<String>();
        ProductLinesPanel = new javax.swing.JPanel();
        panelProductLines = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        ProductsPane3BtnAdd = new javax.swing.JButton();
        ProductsPane3BtnSave = new javax.swing.JButton();
        ProductsPane3BtnDelete = new javax.swing.JButton();
        ProductsPane3TxtProductLineName = new javax.swing.JTextField();
        ProductsPane3BtnClear = new javax.swing.JButton();
        panelTableProductLines = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ProductsPane3Table = new javax.swing.JTable();
        ItemsPanel = new javax.swing.JPanel();
        panelProductsItemDetails = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        ProductsPane4TxtItemName = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        ProductsPane4BtnAdd = new javax.swing.JButton();
        ProductsPane4BtnSave = new javax.swing.JButton();
        ProductsPane4BtnDelete = new javax.swing.JButton();
        ProductsPane4ItemMeasureType = new javax.swing.JComboBox<>();
        ProductsPane4BtnClear = new javax.swing.JButton();
        panelTableItems = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ProductsPane4Table = new javax.swing.JTable();
        ProductsStockPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ProductsPane5TxtProduct = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        ProductsPane5SearchList = new javax.swing.JList<>();
        productPane5BtnSearch = new javax.swing.JButton();
        ProductsPane5CBoxProduct = new javax.swing.JComboBox<>();
        lblProduct2 = new javax.swing.JLabel();
        ProductsPane5TxtQty = new javax.swing.JTextField();
        ProductsPane5BtnAdd = new javax.swing.JButton();
        ProductsPane5BtnReleaseItems = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        ProductsPane5BtnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProductsPane5Table = new javax.swing.JTable();
        clientPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CustomersTxtSearch = new javax.swing.JTextField();
        CustomersBtnSearch = new javax.swing.JButton();
        panelSuppliersOperations1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CustomersTxtDocumentId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CustomersTxtLastname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CustomersTxtEmail = new javax.swing.JTextField();
        CustomersBtnAdd = new javax.swing.JButton();
        CustomersBtnSave = new javax.swing.JButton();
        CustomersBtnDelete = new javax.swing.JButton();
        CustomersTxtName = new javax.swing.JTextField();
        CustomersTxtPhone = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        CustomersBtnClear = new javax.swing.JButton();
        tablePanelCustomers = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        CustomersTable = new javax.swing.JTable();
        supplierPanel = new javax.swing.JPanel();
        panelSuppliersTitle = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        SuppliersBtnSearch = new javax.swing.JButton();
        SuppliersTxtSearch = new javax.swing.JTextField();
        panelSuppliersMain = new javax.swing.JTabbedPane();
        panelSupplierInfo = new javax.swing.JPanel();
        tablePanelSuppliers2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        SuppliersPane1Table = new javax.swing.JTable();
        panelSuppliersOperations3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        SuppliersPane1TxtName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        SuppliersPane1TxtDocumentNumber = new javax.swing.JTextField();
        SuppliersPane1DocumentType = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        SuppliersPane1TxtPhone = new javax.swing.JTextField();
        SuppliersPane1BtnAdd = new javax.swing.JButton();
        SuppliersPane1BtnSave = new javax.swing.JButton();
        SuppliersPane1BtnDelete = new javax.swing.JButton();
        SuppliersPane1BtnClear = new javax.swing.JButton();
        panelPurchases = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        SuppliersPane2TxtTotalCost = new javax.swing.JTextField();
        SuppliersPane2BtnBuy = new javax.swing.JButton();
        SuppliersPane2BtnClear = new javax.swing.JButton();
        SuppliersPane2TxtQuantity = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        SuppliersPane2ItemList = new javax.swing.JComboBox<>();
        SuppliersPane2SupplierList = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SuppliersPane2Table = new javax.swing.JTable();
        adminPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        AdminTxtSearch = new javax.swing.JTextField();
        AdminBtnSearch = new javax.swing.JButton();
        tablePanelSuppliers1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        AdminTable = new javax.swing.JTable();
        panelSuppliersOperations2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        AdminTxtName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AdminTxtEmail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        AdminTxtPhone = new javax.swing.JTextField();
        AdminBtnAdd = new javax.swing.JButton();
        AdminBtnSave = new javax.swing.JButton();
        AdminBtnDelete = new javax.swing.JButton();
        AdminTxtLastname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AdminJobTitleList = new javax.swing.JComboBox<>();
        AdminBtnClear = new javax.swing.JButton();
        reportsPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        subPanelReports = new javax.swing.JPanel();
        ReportsPurchasesOrSales = new javax.swing.JComboBox<>();
        ReportsFromDate = new com.toedter.calendar.JDateChooser();
        ReportsToDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ReportsTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mainPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        mainPanel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        panelSalesTittle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTittleSales.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTittleSales.setText("Sales");

        SaleTxtEmployeeName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        SaleTxtEmployeeID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleTxtEmployeeID.setText("5");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel43.setText("Seller ID :");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel44.setText("Seller :");

        javax.swing.GroupLayout panelSalesTittleLayout = new javax.swing.GroupLayout(panelSalesTittle);
        panelSalesTittle.setLayout(panelSalesTittleLayout);
        panelSalesTittleLayout.setHorizontalGroup(
            panelSalesTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalesTittleLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTittleSales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(SaleTxtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addComponent(SaleTxtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSalesTittleLayout.setVerticalGroup(
            panelSalesTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalesTittleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTittleSales, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelSalesTittleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalesTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SaleTxtEmployeeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SaleTxtEmployeeName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelSalesInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelSalesInfo.setPreferredSize(new java.awt.Dimension(420, 712));

        lblSaleDetails.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSaleDetails.setText("Sale details");

        lblProduct.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProduct.setText("Product :");

        SaleBtnDropProduct.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleBtnDropProduct.setText("-");
        SaleBtnDropProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleBtnDropProductActionPerformed(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPrice.setText("Price :");

        lblDiscount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDiscount.setText("Discount :");

        SaleTxtDiscount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleTxtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SaleTxtDiscountKeyReleased(evt);
            }
        });

        SaleTxtPrice.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleTxtPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaleTxtPrice.setText("0.00");
        SaleTxtPrice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SaleTxtPrice.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                SaleTxtPricePropertyChange(evt);
            }
        });

        SaleProductList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        SaleProductList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaleProductListMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SaleProductList);

        SaleBtnClearAll.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleBtnClearAll.setText("Clear All");
        SaleBtnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleBtnClearAllActionPerformed(evt);
            }
        });

        SaleDiscountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$", "%" }));
        SaleDiscountType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SaleDiscountTypeItemStateChanged(evt);
            }
        });

        SaleProductCBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        SaleBtnSearchProduct1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleBtnSearchProduct1.setText("+");
        SaleBtnSearchProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleBtnSearchProduct1ActionPerformed(evt);
            }
        });

        saleBtnSearchProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saleBtnSearchProduct.setText("Search");
        saleBtnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleBtnSearchProductActionPerformed(evt);
            }
        });

        saleSearchList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saleSearchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleSearchListMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(saleSearchList);

        saleTxtQty.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saleTxtQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        javax.swing.GroupLayout panelSalesInfoLayout = new javax.swing.GroupLayout(panelSalesInfo);
        panelSalesInfo.setLayout(panelSalesInfoLayout);
        panelSalesInfoLayout.setHorizontalGroup(
            panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSalesInfoLayout.createSequentialGroup()
                .addGap(0, 133, Short.MAX_VALUE)
                .addComponent(lblSaleDetails)
                .addGap(159, 159, 159))
            .addGroup(panelSalesInfoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProduct)
                    .addGroup(panelSalesInfoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelSalesInfoLayout.createSequentialGroup()
                                .addComponent(saleTxtProduct)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saleBtnSearchProduct))
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSalesInfoLayout.createSequentialGroup()
                                .addComponent(saleTxtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SaleBtnSearchProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SaleBtnDropProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SaleProductCBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelSalesInfoLayout.createSequentialGroup()
                                .addComponent(SaleBtnClearAll)
                                .addGap(122, 122, 122))
                            .addComponent(SaleTxtPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSalesInfoLayout.createSequentialGroup()
                                .addComponent(SaleTxtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SaleDiscountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiscount, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelSalesInfoLayout.setVerticalGroup(
            panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalesInfoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblSaleDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSalesInfoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(saleBtnSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(saleTxtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(SaleProductCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SaleBtnSearchProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SaleBtnDropProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(saleTxtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaleTxtPrice)
                .addGap(18, 18, 18)
                .addComponent(lblDiscount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSalesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaleDiscountType)
                    .addComponent(SaleTxtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaleBtnClearAll)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        panelSalesTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SaleTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Code", "Name", "Price", "On stock", "Product line"
            }
        ));
        jScrollPane13.setViewportView(SaleTableProduct);

        javax.swing.GroupLayout panelSalesTableLayout = new javax.swing.GroupLayout(panelSalesTable);
        panelSalesTable.setLayout(panelSalesTableLayout);
        panelSalesTableLayout.setHorizontalGroup(
            panelSalesTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalesTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13)
                .addContainerGap())
        );
        panelSalesTableLayout.setVerticalGroup(
            panelSalesTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalesTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSaleCustomer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCustomer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCustomer.setText("Customer");

        SaleBtnSearchCustomer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleBtnSearchCustomer.setText("Search");
        SaleBtnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleBtnSearchCustomerActionPerformed(evt);
            }
        });

        SaleBtnClearCustomer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleBtnClearCustomer.setText("Clear");
        SaleBtnClearCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleBtnClearCustomerActionPerformed(evt);
            }
        });

        SaleTxtCustomerId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblProduct1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProduct1.setText("Name :");

        SaleTxtCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleTxtCustomerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblProduct3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProduct3.setText("Id :");

        javax.swing.GroupLayout panelSaleCustomerLayout = new javax.swing.GroupLayout(panelSaleCustomer);
        panelSaleCustomer.setLayout(panelSaleCustomerLayout);
        panelSaleCustomerLayout.setHorizontalGroup(
            panelSaleCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSaleCustomerLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelSaleCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProduct1)
                    .addComponent(lblProduct3)
                    .addComponent(SaleTxtCustomerId, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(SaleTxtCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(panelSaleCustomerLayout.createSequentialGroup()
                .addGroup(panelSaleCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSaleCustomerLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lblCustomer))
                    .addGroup(panelSaleCustomerLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(SaleBtnSearchCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(SaleBtnClearCustomer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSaleCustomerLayout.setVerticalGroup(
            panelSaleCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaleCustomerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProduct3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaleTxtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaleTxtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSaleCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaleBtnClearCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaleBtnSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        panelSaleOperation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTotalCost.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotalCost.setText("Total cost :");

        lblDollar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblDollar.setForeground(new java.awt.Color(0, 153, 0));
        lblDollar.setText("$.");

        SaleTxtTotalCost.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleTxtTotalCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaleTxtTotalCost.setText("0.00");
        SaleTxtTotalCost.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblCustomerPay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCustomerPay.setText("Customer pays with :");

        SaleTxtCustomerPay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        SaleBtnPay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SaleBtnPay.setText("Pay");
        SaleBtnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleBtnPayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSaleOperationLayout = new javax.swing.GroupLayout(panelSaleOperation);
        panelSaleOperation.setLayout(panelSaleOperationLayout);
        panelSaleOperationLayout.setHorizontalGroup(
            panelSaleOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaleOperationLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelSaleOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerPay)
                    .addGroup(panelSaleOperationLayout.createSequentialGroup()
                        .addComponent(lblDollar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaleTxtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SaleTxtCustomerPay, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalCost))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSaleOperationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaleBtnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        panelSaleOperationLayout.setVerticalGroup(
            panelSaleOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaleOperationLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSaleOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDollar)
                    .addComponent(SaleTxtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCustomerPay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaleTxtCustomerPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SaleBtnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout salePanelLayout = new javax.swing.GroupLayout(salePanel);
        salePanel.setLayout(salePanelLayout);
        salePanelLayout.setHorizontalGroup(
            salePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(salePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSalesTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(salePanelLayout.createSequentialGroup()
                        .addComponent(panelSalesInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(salePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(salePanelLayout.createSequentialGroup()
                                .addComponent(panelSaleCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelSaleOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(panelSalesTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        salePanelLayout.setVerticalGroup(
            salePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSalesTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(salePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(salePanelLayout.createSequentialGroup()
                        .addComponent(panelSalesTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(salePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelSaleCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelSaleOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(panelSalesInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(709, Short.MAX_VALUE))
        );

        mainPanel.addTab("Sale", null, salePanel, "Sell");

        productPanel.setPreferredSize(new java.awt.Dimension(1000, 800));

        panelProductsTittle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelProductsTittle.setPreferredSize(new java.awt.Dimension(1030, 70));

        lblProducts.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblProducts.setText("Products");

        ProductsTxtSearch.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        ProductsBtnSearch.setText("Search");
        ProductsBtnSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProductsBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsBtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductsTittleLayout = new javax.swing.GroupLayout(panelProductsTittle);
        panelProductsTittle.setLayout(panelProductsTittleLayout);
        panelProductsTittleLayout.setHorizontalGroup(
            panelProductsTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsTittleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProductsTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProductsBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        panelProductsTittleLayout.setVerticalGroup(
            panelProductsTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsTittleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductsTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductsTittleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelProductsTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProductsBtnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProductsTxtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        ProductsTablePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(jTable1);

        javax.swing.GroupLayout ProductsTablePanelLayout = new javax.swing.GroupLayout(ProductsTablePanel);
        ProductsTablePanel.setLayout(ProductsTablePanelLayout);
        ProductsTablePanelLayout.setHorizontalGroup(
            ProductsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProductsTablePanelLayout.setVerticalGroup(
            ProductsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(707, Short.MAX_VALUE))
        );

        panelProducts.addTab("Products", ProductsTablePanel);

        panelTableProductDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane9.setViewportView(ProductsPane2Table);

        javax.swing.GroupLayout panelTableProductDetailsLayout = new javax.swing.GroupLayout(panelTableProductDetails);
        panelTableProductDetails.setLayout(panelTableProductDetailsLayout);
        panelTableProductDetailsLayout.setHorizontalGroup(
            panelTableProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableProductDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTableProductDetailsLayout.setVerticalGroup(
            panelTableProductDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableProductDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );

        panelProductDetailsOperation.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelProductDetailsOperation.setMaximumSize(new java.awt.Dimension(1200, 1200));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setText("Product details");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setText("Code :");

        ProductsPane2TxtProductCode.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductsPane2TxtProductCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ProductsPane2TxtProductCodeKeyPressed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("Product name :");

        ProductsPane2ProductPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductsPane2ProductPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ProductsPane2ProductPriceKeyPressed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Price :");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setText("Product line :");

        ProductsPane2BtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane2BtnAdd.setText("Add");
        ProductsPane2BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane2BtnAddActionPerformed(evt);
            }
        });

        ProductsPane2BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane2BtnDelete.setText("Delete");
        ProductsPane2BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane2BtnDeleteActionPerformed(evt);
            }
        });

        ProductsPane2TxtProductName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductsPane2TxtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ProductsPane2TxtProductNameKeyPressed(evt);
            }
        });

        ProductsPane2ProductLine.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductsPane2ProductLine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Item :");

        ProductsPane2Item.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductsPane2Item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        ProductsPane2AddItem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductsPane2AddItem.setText("+");
        ProductsPane2AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane2AddItemActionPerformed(evt);
            }
        });

        ProductsPane2BtnRemoveItem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane2BtnRemoveItem.setText("-");
        ProductsPane2BtnRemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane2BtnRemoveItemActionPerformed(evt);
            }
        });

        ProductsPane2BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane2BtnClear.setText("Clear/Refresh");
        ProductsPane2BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane2BtnClearActionPerformed(evt);
            }
        });

        ProductsPane2ItemList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProductsPane2ItemList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ProductsPane2ItemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsPane2ItemListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductsPane2ItemList);

        javax.swing.GroupLayout panelProductDetailsOperationLayout = new javax.swing.GroupLayout(panelProductDetailsOperation);
        panelProductDetailsOperation.setLayout(panelProductDetailsOperationLayout);
        panelProductDetailsOperationLayout.setHorizontalGroup(
            panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductDetailsOperationLayout.createSequentialGroup()
                .addGroup(panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductDetailsOperationLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel31))
                    .addGroup(panelProductDetailsOperationLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel36)
                            .addComponent(ProductsPane2ProductPrice)
                            .addComponent(jLabel35)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductDetailsOperationLayout.createSequentialGroup()
                                .addComponent(ProductsPane2Item, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProductsPane2AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProductsPane2BtnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel37)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33)
                            .addComponent(ProductsPane2TxtProductCode)
                            .addComponent(jScrollPane1)
                            .addComponent(ProductsPane2TxtProductName)
                            .addComponent(ProductsPane2ProductLine, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductDetailsOperationLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductDetailsOperationLayout.createSequentialGroup()
                                .addComponent(ProductsPane2BtnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProductsPane2BtnDelete))
                            .addComponent(ProductsPane2BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelProductDetailsOperationLayout.setVerticalGroup(
            panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductDetailsOperationLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductsPane2TxtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductsPane2TxtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductsPane2ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductsPane2ProductLine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProductsPane2Item, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProductsPane2AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ProductsPane2BtnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(panelProductDetailsOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductsPane2BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductsPane2BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProductsPane2BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ProductDetailsPanelLayout = new javax.swing.GroupLayout(ProductDetailsPanel);
        ProductDetailsPanel.setLayout(ProductDetailsPanelLayout);
        ProductDetailsPanelLayout.setHorizontalGroup(
            ProductDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductDetailsPanelLayout.createSequentialGroup()
                .addComponent(panelProductDetailsOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableProductDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProductDetailsPanelLayout.setVerticalGroup(
            ProductDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProductDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTableProductDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProductDetailsOperation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(700, Short.MAX_VALUE))
        );

        panelProducts.addTab("Add product", ProductDetailsPanel);

        panelProductLines.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setText("Product lines");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setText("Name :");

        ProductsPane3BtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane3BtnAdd.setText("Add");
        ProductsPane3BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane3BtnAddActionPerformed(evt);
            }
        });

        ProductsPane3BtnSave.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane3BtnSave.setText("Save");
        ProductsPane3BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane3BtnSaveActionPerformed(evt);
            }
        });

        ProductsPane3BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane3BtnDelete.setText("Delete");
        ProductsPane3BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane3BtnDeleteActionPerformed(evt);
            }
        });

        ProductsPane3TxtProductLineName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        ProductsPane3BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane3BtnClear.setText("Clear");
        ProductsPane3BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane3BtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductLinesLayout = new javax.swing.GroupLayout(panelProductLines);
        panelProductLines.setLayout(panelProductLinesLayout);
        panelProductLinesLayout.setHorizontalGroup(
            panelProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLinesLayout.createSequentialGroup()
                .addGroup(panelProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductLinesLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(ProductsPane3TxtProductLineName, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductLinesLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel38))
                    .addGroup(panelProductLinesLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(ProductsPane3BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductsPane3BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductsPane3BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProductLinesLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(ProductsPane3BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelProductLinesLayout.setVerticalGroup(
            panelProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLinesLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel38)
                .addGap(45, 45, 45)
                .addComponent(jLabel39)
                .addGap(28, 28, 28)
                .addComponent(ProductsPane3TxtProductLineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(panelProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductsPane3BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductsPane3BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductsPane3BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ProductsPane3BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTableProductLines.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ProductsPane3Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductsPane3Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsPane3TableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(ProductsPane3Table);
        if (ProductsPane3Table.getColumnModel().getColumnCount() > 0) {
            ProductsPane3Table.getColumnModel().getColumn(0).setResizable(false);
            ProductsPane3Table.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelTableProductLinesLayout = new javax.swing.GroupLayout(panelTableProductLines);
        panelTableProductLines.setLayout(panelTableProductLinesLayout);
        panelTableProductLinesLayout.setHorizontalGroup(
            panelTableProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableProductLinesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTableProductLinesLayout.setVerticalGroup(
            panelTableProductLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableProductLinesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ProductLinesPanelLayout = new javax.swing.GroupLayout(ProductLinesPanel);
        ProductLinesPanel.setLayout(ProductLinesPanelLayout);
        ProductLinesPanelLayout.setHorizontalGroup(
            ProductLinesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductLinesPanelLayout.createSequentialGroup()
                .addComponent(panelProductLines, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableProductLines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProductLinesPanelLayout.setVerticalGroup(
            ProductLinesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductLinesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProductLinesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelProductLines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTableProductLines, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(702, Short.MAX_VALUE))
        );

        panelProducts.addTab("Product lines", ProductLinesPanel);

        panelProductsItemDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setText("Item details");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setText("Name :");

        ProductsPane4TxtItemName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setText("Measure :");

        ProductsPane4BtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane4BtnAdd.setText("Add");
        ProductsPane4BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane4BtnAddActionPerformed(evt);
            }
        });

        ProductsPane4BtnSave.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane4BtnSave.setText("Save");
        ProductsPane4BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane4BtnSaveActionPerformed(evt);
            }
        });

        ProductsPane4BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane4BtnDelete.setText("Delete");
        ProductsPane4BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane4BtnDeleteActionPerformed(evt);
            }
        });

        ProductsPane4ItemMeasureType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unit", "Kilogram", "Pound", "Liter" }));

        ProductsPane4BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane4BtnClear.setText("Clear");
        ProductsPane4BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane4BtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProductsItemDetailsLayout = new javax.swing.GroupLayout(panelProductsItemDetails);
        panelProductsItemDetails.setLayout(panelProductsItemDetailsLayout);
        panelProductsItemDetailsLayout.setHorizontalGroup(
            panelProductsItemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsItemDetailsLayout.createSequentialGroup()
                .addGroup(panelProductsItemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductsItemDetailsLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel29))
                    .addGroup(panelProductsItemDetailsLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelProductsItemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(ProductsPane4TxtItemName)
                            .addComponent(ProductsPane4ItemMeasureType, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductsItemDetailsLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(ProductsPane4BtnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductsPane4BtnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductsPane4BtnDelete))
                    .addGroup(panelProductsItemDetailsLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(ProductsPane4BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelProductsItemDetailsLayout.setVerticalGroup(
            panelProductsItemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsItemDetailsLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel29)
                .addGap(51, 51, 51)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(ProductsPane4TxtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(ProductsPane4ItemMeasureType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(panelProductsItemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProductsPane4BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProductsItemDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProductsPane4BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProductsPane4BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ProductsPane4BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        panelTableItems.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ProductsPane4Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Measure"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductsPane4Table.getTableHeader().setReorderingAllowed(false);
        ProductsPane4Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsPane4TableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(ProductsPane4Table);
        if (ProductsPane4Table.getColumnModel().getColumnCount() > 0) {
            ProductsPane4Table.getColumnModel().getColumn(0).setResizable(false);
            ProductsPane4Table.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelTableItemsLayout = new javax.swing.GroupLayout(panelTableItems);
        panelTableItems.setLayout(panelTableItemsLayout);
        panelTableItemsLayout.setHorizontalGroup(
            panelTableItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTableItemsLayout.setVerticalGroup(
            panelTableItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );

        javax.swing.GroupLayout ItemsPanelLayout = new javax.swing.GroupLayout(ItemsPanel);
        ItemsPanel.setLayout(ItemsPanelLayout);
        ItemsPanelLayout.setHorizontalGroup(
            ItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemsPanelLayout.createSequentialGroup()
                .addComponent(panelProductsItemDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ItemsPanelLayout.setVerticalGroup(
            ItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelProductsItemDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTableItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(703, Short.MAX_VALUE))
        );

        panelProducts.addTab("Add item", ItemsPanel);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setText("Products on stock");

        ProductsPane5SearchList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProductsPane5SearchList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsPane5SearchListMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(ProductsPane5SearchList);

        productPane5BtnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productPane5BtnSearch.setText("Search");
        productPane5BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPane5BtnSearchActionPerformed(evt);
            }
        });

        ProductsPane5CBoxProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--" }));

        lblProduct2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProduct2.setText("Product :");

        ProductsPane5TxtQty.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        ProductsPane5BtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane5BtnAdd.setText("Add stock");
        ProductsPane5BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane5BtnAddActionPerformed(evt);
            }
        });

        ProductsPane5BtnReleaseItems.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane5BtnReleaseItems.setText("Release Items");
        ProductsPane5BtnReleaseItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane5BtnReleaseItemsActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setText("Stock");

        ProductsPane5BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProductsPane5BtnClear.setText("Clear/Refresh");
        ProductsPane5BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductsPane5BtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProductsPane5CBoxProduct, javax.swing.GroupLayout.Alignment.TRAILING, 0, 346, Short.MAX_VALUE)
                            .addComponent(ProductsPane5TxtQty, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ProductsPane5BtnReleaseItems)
                                .addComponent(ProductsPane5BtnClear)
                                .addComponent(ProductsPane5BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane14)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(ProductsPane5TxtProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(productPane5BtnSearch))
                        .addComponent(lblProduct2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblProduct2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(productPane5BtnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(ProductsPane5TxtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductsPane5CBoxProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProductsPane5TxtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(ProductsPane5BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductsPane5BtnReleaseItems, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductsPane5BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ProductsPane5Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ProductsPane5Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductsPane5TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ProductsPane5Table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout ProductsStockPanelLayout = new javax.swing.GroupLayout(ProductsStockPanel);
        ProductsStockPanel.setLayout(ProductsStockPanelLayout);
        ProductsStockPanelLayout.setHorizontalGroup(
            ProductsStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsStockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProductsStockPanelLayout.setVerticalGroup(
            ProductsStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsStockPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProductsStockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(700, Short.MAX_VALUE))
        );

        panelProducts.addTab("Stock", ProductsStockPanel);

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelProducts)
                    .addComponent(panelProductsTittle, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE))
                .addContainerGap())
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProductsTittle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProducts)
                .addContainerGap())
        );

        mainPanel.addTab("Products", null, productPanel, "Products");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel2.setText("Customers");

        CustomersTxtSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        CustomersBtnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CustomersBtnSearch.setText("Search");
        CustomersBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersBtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CustomersTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CustomersBtnSearch)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CustomersBtnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(CustomersTxtSearch))))
                .addContainerGap())
        );

        panelSuppliersOperations1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Customer information");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Document id :");

        CustomersTxtDocumentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CustomersTxtDocumentId.setOpaque(true);
        CustomersTxtDocumentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CustomersTxtDocumentIdKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Name :");

        CustomersTxtLastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CustomersTxtLastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CustomersTxtLastnameKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Lastname :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Email (Optional) :");

        CustomersBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustomersBtnAdd.setText("Add");
        CustomersBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersBtnAddActionPerformed(evt);
            }
        });

        CustomersBtnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustomersBtnSave.setText("Save");
        CustomersBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersBtnSaveActionPerformed(evt);
            }
        });

        CustomersBtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustomersBtnDelete.setText("Delete");
        CustomersBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersBtnDeleteActionPerformed(evt);
            }
        });

        CustomersTxtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CustomersTxtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CustomersTxtNameKeyTyped(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setText("Phone (Optional) :");

        CustomersBtnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustomersBtnClear.setText("Clear/Refresh");
        CustomersBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersBtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuppliersOperations1Layout = new javax.swing.GroupLayout(panelSuppliersOperations1);
        panelSuppliersOperations1.setLayout(panelSuppliersOperations1Layout);
        panelSuppliersOperations1Layout.setHorizontalGroup(
            panelSuppliersOperations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersOperations1Layout.createSequentialGroup()
                .addGroup(panelSuppliersOperations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuppliersOperations1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel11))
                    .addGroup(panelSuppliersOperations1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelSuppliersOperations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomersTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSuppliersOperations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14)
                                .addComponent(CustomersTxtLastname)
                                .addComponent(CustomersTxtDocumentId)
                                .addComponent(CustomersTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CustomersTxtName)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15))
                            .addComponent(jLabel41)))
                    .addGroup(panelSuppliersOperations1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(CustomersBtnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(CustomersBtnSave)
                        .addGap(18, 18, 18)
                        .addComponent(CustomersBtnDelete))
                    .addGroup(panelSuppliersOperations1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(CustomersBtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelSuppliersOperations1Layout.setVerticalGroup(
            panelSuppliersOperations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersOperations1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel11)
                .addGap(54, 54, 54)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(CustomersTxtDocumentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(CustomersTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(CustomersTxtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(CustomersTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addGap(18, 18, 18)
                .addComponent(CustomersTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(panelSuppliersOperations1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomersBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomersBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomersBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(CustomersBtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        tablePanelCustomers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        CustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Lastname", "Email", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CustomersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomersTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(CustomersTable);

        javax.swing.GroupLayout tablePanelCustomersLayout = new javax.swing.GroupLayout(tablePanelCustomers);
        tablePanelCustomers.setLayout(tablePanelCustomersLayout);
        tablePanelCustomersLayout.setHorizontalGroup(
            tablePanelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelCustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelCustomersLayout.setVerticalGroup(
            tablePanelCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelCustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addComponent(panelSuppliersOperations1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tablePanelCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSuppliersOperations1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanelCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(711, Short.MAX_VALUE))
        );

        mainPanel.addTab("Customers", null, clientPanel, "Credits");

        panelSuppliersTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel3.setText("Suppliers");

        SuppliersBtnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SuppliersBtnSearch.setText("Search");
        SuppliersBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersBtnSearchActionPerformed(evt);
            }
        });

        SuppliersTxtSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout panelSuppliersTitleLayout = new javax.swing.GroupLayout(panelSuppliersTitle);
        panelSuppliersTitle.setLayout(panelSuppliersTitleLayout);
        panelSuppliersTitleLayout.setHorizontalGroup(
            panelSuppliersTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersTitleLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SuppliersTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SuppliersBtnSearch)
                .addGap(22, 22, 22))
        );
        panelSuppliersTitleLayout.setVerticalGroup(
            panelSuppliersTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersTitleLayout.createSequentialGroup()
                .addGroup(panelSuppliersTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuppliersTitleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                    .addGroup(panelSuppliersTitleLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelSuppliersTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SuppliersTxtSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SuppliersBtnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        tablePanelSuppliers2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SuppliersPane1Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Supplier", "Document", "Document num", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SuppliersPane1Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuppliersPane1TableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(SuppliersPane1Table);

        javax.swing.GroupLayout tablePanelSuppliers2Layout = new javax.swing.GroupLayout(tablePanelSuppliers2);
        tablePanelSuppliers2.setLayout(tablePanelSuppliers2Layout);
        tablePanelSuppliers2Layout.setHorizontalGroup(
            tablePanelSuppliers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelSuppliers2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelSuppliers2Layout.setVerticalGroup(
            tablePanelSuppliers2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelSuppliers2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSuppliersOperations3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setText("Supplier information");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Name :");

        SuppliersPane1TxtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SuppliersPane1TxtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SuppliersPane1TxtNameKeyTyped(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Document type :");

        SuppliersPane1TxtDocumentNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SuppliersPane1TxtDocumentNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SuppliersPane1TxtDocumentNumberKeyTyped(evt);
            }
        });

        SuppliersPane1DocumentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUC", "DNI" }));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Document number :");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("Phone :");

        SuppliersPane1TxtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SuppliersPane1TxtPhoneKeyTyped(evt);
            }
        });

        SuppliersPane1BtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SuppliersPane1BtnAdd.setText("Add");
        SuppliersPane1BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersPane1BtnAddActionPerformed(evt);
            }
        });

        SuppliersPane1BtnSave.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SuppliersPane1BtnSave.setText("Save");
        SuppliersPane1BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersPane1BtnSaveActionPerformed(evt);
            }
        });

        SuppliersPane1BtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SuppliersPane1BtnDelete.setText("Delete");
        SuppliersPane1BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersPane1BtnDeleteActionPerformed(evt);
            }
        });

        SuppliersPane1BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SuppliersPane1BtnClear.setText("Clear/Refresh");
        SuppliersPane1BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersPane1BtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuppliersOperations3Layout = new javax.swing.GroupLayout(panelSuppliersOperations3);
        panelSuppliersOperations3.setLayout(panelSuppliersOperations3Layout);
        panelSuppliersOperations3Layout.setHorizontalGroup(
            panelSuppliersOperations3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersOperations3Layout.createSequentialGroup()
                .addGroup(panelSuppliersOperations3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuppliersOperations3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelSuppliersOperations3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(SuppliersPane1TxtDocumentNumber)
                            .addComponent(SuppliersPane1DocumentType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SuppliersPane1TxtName)
                            .addComponent(SuppliersPane1TxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSuppliersOperations3Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel21))
                    .addGroup(panelSuppliersOperations3Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(SuppliersPane1BtnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(SuppliersPane1BtnSave)
                        .addGap(18, 18, 18)
                        .addComponent(SuppliersPane1BtnDelete))
                    .addGroup(panelSuppliersOperations3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(SuppliersPane1BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelSuppliersOperations3Layout.setVerticalGroup(
            panelSuppliersOperations3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersOperations3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel21)
                .addGap(54, 54, 54)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(SuppliersPane1TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(SuppliersPane1DocumentType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(SuppliersPane1TxtDocumentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(SuppliersPane1TxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(panelSuppliersOperations3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SuppliersPane1BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuppliersPane1BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuppliersPane1BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SuppliersPane1BtnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelSupplierInfoLayout = new javax.swing.GroupLayout(panelSupplierInfo);
        panelSupplierInfo.setLayout(panelSupplierInfoLayout);
        panelSupplierInfoLayout.setHorizontalGroup(
            panelSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSupplierInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuppliersOperations3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanelSuppliers2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSupplierInfoLayout.setVerticalGroup(
            panelSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSupplierInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSupplierInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tablePanelSuppliers2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuppliersOperations3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(702, Short.MAX_VALUE))
        );

        panelSuppliersMain.addTab("Supplier info", panelSupplierInfo);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Purchase items");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Quantity :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Total Cost :");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Supplier :");

        SuppliersPane2TxtTotalCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SuppliersPane2TxtTotalCostKeyTyped(evt);
            }
        });

        SuppliersPane2BtnBuy.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SuppliersPane2BtnBuy.setText("Buy");
        SuppliersPane2BtnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersPane2BtnBuyActionPerformed(evt);
            }
        });

        SuppliersPane2BtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SuppliersPane2BtnClear.setText("Clear/Refresh");
        SuppliersPane2BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersPane2BtnClearActionPerformed(evt);
            }
        });

        SuppliersPane2TxtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SuppliersPane2TxtQuantityKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Item :");

        SuppliersPane2ItemList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SuppliersPane2ItemList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SuppliersPane2SupplierList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SuppliersPane2SupplierList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SuppliersPane2TxtTotalCost)
                                    .addComponent(SuppliersPane2TxtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(SuppliersPane2BtnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(SuppliersPane2BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addGap(6, 6, 6)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SuppliersPane2ItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SuppliersPane2SupplierList, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel6)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(SuppliersPane2ItemList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(SuppliersPane2SupplierList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(SuppliersPane2TxtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(SuppliersPane2TxtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SuppliersPane2BtnClear)
                    .addComponent(SuppliersPane2BtnBuy))
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        SuppliersPane2Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Name", "Stock", "Price", "Supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SuppliersPane2Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuppliersPane2TableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(SuppliersPane2Table);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPurchasesLayout = new javax.swing.GroupLayout(panelPurchases);
        panelPurchases.setLayout(panelPurchasesLayout);
        panelPurchasesLayout.setHorizontalGroup(
            panelPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPurchasesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPurchasesLayout.setVerticalGroup(
            panelPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPurchasesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPurchasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(704, Short.MAX_VALUE))
        );

        panelSuppliersMain.addTab("Purchases", panelPurchases);

        javax.swing.GroupLayout supplierPanelLayout = new javax.swing.GroupLayout(supplierPanel);
        supplierPanel.setLayout(supplierPanelLayout);
        supplierPanelLayout.setHorizontalGroup(
            supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSuppliersTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSuppliersMain))
                .addContainerGap())
        );
        supplierPanelLayout.setVerticalGroup(
            supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(supplierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSuppliersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSuppliersMain)
                .addContainerGap())
        );

        mainPanel.addTab("Suppliers", null, supplierPanel, "Purchase");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setText("Administration");

        AdminTxtSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        AdminBtnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdminBtnSearch.setText("Search");
        AdminBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBtnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AdminTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AdminBtnSearch)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(AdminTxtSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(AdminBtnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tablePanelSuppliers1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        AdminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Lastname", "Email", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AdminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(AdminTable);

        javax.swing.GroupLayout tablePanelSuppliers1Layout = new javax.swing.GroupLayout(tablePanelSuppliers1);
        tablePanelSuppliers1.setLayout(tablePanelSuppliers1Layout);
        tablePanelSuppliers1Layout.setHorizontalGroup(
            tablePanelSuppliers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelSuppliers1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelSuppliers1Layout.setVerticalGroup(
            tablePanelSuppliers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelSuppliers1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        panelSuppliersOperations2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setText("User administration");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Name :");

        AdminTxtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminTxtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdminTxtNameKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Lastname :");

        AdminTxtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminTxtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdminTxtEmailKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Email :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Phone :");

        AdminTxtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminTxtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdminTxtPhoneKeyPressed(evt);
            }
        });

        AdminBtnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AdminBtnAdd.setText("Add");
        AdminBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBtnAddActionPerformed(evt);
            }
        });

        AdminBtnSave.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AdminBtnSave.setText("Save");
        AdminBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBtnSaveActionPerformed(evt);
            }
        });

        AdminBtnDelete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AdminBtnDelete.setText("Delete");
        AdminBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBtnDeleteActionPerformed(evt);
            }
        });

        AdminTxtLastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AdminTxtLastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdminTxtLastnameKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Job title :");

        AdminJobTitleList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AdminJobTitleList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seller", "Admin" }));

        AdminBtnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AdminBtnClear.setText("Clear/Refresh");
        AdminBtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBtnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuppliersOperations2Layout = new javax.swing.GroupLayout(panelSuppliersOperations2);
        panelSuppliersOperations2.setLayout(panelSuppliersOperations2Layout);
        panelSuppliersOperations2Layout.setHorizontalGroup(
            panelSuppliersOperations2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuppliersOperations2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(AdminBtnAdd)
                .addGap(18, 18, 18)
                .addComponent(AdminBtnSave)
                .addGap(18, 18, 18)
                .addComponent(AdminBtnDelete)
                .addGap(82, 82, 82))
            .addGroup(panelSuppliersOperations2Layout.createSequentialGroup()
                .addGroup(panelSuppliersOperations2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuppliersOperations2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel16))
                    .addGroup(panelSuppliersOperations2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(panelSuppliersOperations2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(AdminTxtEmail)
                            .addComponent(AdminTxtName)
                            .addComponent(AdminTxtPhone)
                            .addComponent(AdminTxtLastname)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(AdminJobTitleList, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSuppliersOperations2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(AdminBtnClear)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelSuppliersOperations2Layout.setVerticalGroup(
            panelSuppliersOperations2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuppliersOperations2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(AdminTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(AdminTxtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(AdminTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(AdminTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(AdminJobTitleList, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(panelSuppliersOperations2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminBtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AdminBtnClear)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(adminPanelLayout.createSequentialGroup()
                        .addComponent(panelSuppliersOperations2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tablePanelSuppliers1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSuppliersOperations2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tablePanelSuppliers1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 705, Short.MAX_VALUE))
        );

        mainPanel.addTab("Administration", null, adminPanel, "User management");

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel5.setText("Reports");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addContainerGap(929, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        subPanelReports.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ReportsPurchasesOrSales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ReportsPurchasesOrSales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sales", "Purchases" }));

        ReportsFromDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        ReportsToDate.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("From :");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel40.setText("Purchases / Sales");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel42.setText("To :");

        ReportsTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ReportsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(ReportsTable);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Clear / Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelReportsLayout = new javax.swing.GroupLayout(subPanelReports);
        subPanelReports.setLayout(subPanelReportsLayout);
        subPanelReportsLayout.setHorizontalGroup(
            subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelReportsLayout.createSequentialGroup()
                .addGroup(subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelReportsLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReportsPurchasesOrSales, javax.swing.GroupLayout.Alignment.TRAILING, 0, 263, Short.MAX_VALUE)
                            .addComponent(ReportsToDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(ReportsFromDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(subPanelReportsLayout.createSequentialGroup()
                        .addGroup(subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subPanelReportsLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(subPanelReportsLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        subPanelReportsLayout.setVerticalGroup(
            subPanelReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelReportsLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReportsFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ReportsToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReportsPurchasesOrSales, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(subPanelReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15)
                .addContainerGap())
        );

        javax.swing.GroupLayout reportsPanelLayout = new javax.swing.GroupLayout(reportsPanel);
        reportsPanel.setLayout(reportsPanelLayout);
        reportsPanelLayout.setHorizontalGroup(
            reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subPanelReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        reportsPanelLayout.setVerticalGroup(
            reportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subPanelReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.addTab("Reports", null, reportsPanel, "Purchase and sale details");

        getContentPane().add(mainPanel, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myInitComponents() {
        ControlSuppliersItems csItems = new ControlSuppliersItems();
        ControlSuppliersInfo csInfo = new ControlSuppliersInfo();
        ControlProductsItems cpItems = new ControlProductsItems();
        ControlProductLine cpLine = new ControlProductLine();
        ControlProducts cProduct = new ControlProducts();
        ControlProductsTable cpTable = new ControlProductsTable();
        ControlCustomers cC = new ControlCustomers();
        var discount_text = new TextPrompt("0.00", SaleTxtDiscount);
        var customer_Id_text = new TextPrompt("12345678", SaleTxtCustomerId);
        ControlAdmin ca = new ControlAdmin();
        ControlSales cs = new ControlSales();
        ControlProductStock cps = new ControlProductStock();
        ControlReports cr = new ControlReports();
        cr.loadReportsTable();
        cps.loadProducts();
        cps.loadProductStockTable();
        cs.loadProductsComboBox();
        ca.loadAdminTable();
        cC.loadCustomer();
        cpTable.loadProductsTable();
        cProduct.loadProducts();
        cProduct.loadProductsTable();
        cpLine.loadProductLines();
        cpItems.loadItems();
        csInfo.loadSuppliersTable();
        csItems.loadItemList();
        csItems.loadSupplierList();
        csItems.loadItemPurchased();
    }

    private void ProductsBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsBtnSearchActionPerformed
        if (ItemsPanel.isShowing()) {
            ControlProductsItems cpItems = new ControlProductsItems();
            cpItems.searchItem();
        } else if (ProductLinesPanel.isShowing()) {
            ControlProductLine cpLine = new ControlProductLine();
            cpLine.searchLine();
        } else if (ProductDetailsPanel.isShowing()) {
            ControlProducts cProduct = new ControlProducts();
            cProduct.searchLine();
        } else if (ProductsTablePanel.isShowing()) {
            ControlProductsTable cpTable = new ControlProductsTable();
            cpTable.searchLine();
        } else if(ProductsStockPanel.isShowing()){
            ControlProductStock cps = new ControlProductStock();
            cps.btnSearchNum();
        }
    }//GEN-LAST:event_ProductsBtnSearchActionPerformed

    private void SuppliersPane1BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersPane1BtnAddActionPerformed
        ControlSuppliersInfo ci = new ControlSuppliersInfo();
        switch (ci.addSupplier()) {
            case 1 -> {
                SuppliersPane1TxtName.requestFocus();
                SuppliersPane1TxtName.setBackground(new Color(252, 171, 171));
            }
            case 2 -> {
                SuppliersPane1TxtDocumentNumber.requestFocus();
                SuppliersPane1TxtDocumentNumber.setBackground(new Color(252, 171, 171));
            }
            case 3 -> {
                SuppliersPane1TxtPhone.requestFocus();
                SuppliersPane1TxtPhone.setBackground(new Color(252, 171, 171));
            }
        }
    }//GEN-LAST:event_SuppliersPane1BtnAddActionPerformed

    private void SuppliersPane1BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersPane1BtnSaveActionPerformed
        ControlSuppliersInfo csInfo = new ControlSuppliersInfo();
        csInfo.saveSupplier();
    }//GEN-LAST:event_SuppliersPane1BtnSaveActionPerformed

    private void SuppliersPane2BtnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersPane2BtnBuyActionPerformed
        ControlSuppliersItems csItems = new ControlSuppliersItems();
        switch (csItems.addPurchaseItems()) {
            case 2 -> {
                panelProducts.setSelectedIndex(3);//focus products item
            }
            case 4 -> {
                panelSuppliersMain.setSelectedIndex(0);//focus products item
            }
            case 6 -> {
                SuppliersPane2TxtQuantity.requestFocus();
                SuppliersPane2TxtQuantity.setBackground(new Color(252, 171, 171));
            }
            case 7 -> {
                SuppliersPane2TxtTotalCost.requestFocus();
                SuppliersPane2TxtTotalCost.setBackground(new Color(252, 171, 171));
            }
        }
    }//GEN-LAST:event_SuppliersPane2BtnBuyActionPerformed

    private void ProductsPane4BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane4BtnAddActionPerformed
        ControlProductsItems cpItems = new ControlProductsItems();
        cpItems.addItem();
    }//GEN-LAST:event_ProductsPane4BtnAddActionPerformed

    private void ProductsPane4BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane4BtnSaveActionPerformed
        try {
            ControlProductsItems cpItems = new ControlProductsItems();
            cpItems.saveItem();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_ProductsPane4BtnSaveActionPerformed

    private void ProductsPane2BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane2BtnAddActionPerformed
        ControlProducts cProduct = new ControlProducts();
        switch (cProduct.addProduct()) {
            case 2 -> {
                ProductsPane2TxtProductCode.requestFocus();
                ProductsPane2TxtProductCode.setBackground(new Color(252, 171, 171));
            }
            case 3 -> {
                ProductsPane2TxtProductName.requestFocus();
                ProductsPane2TxtProductName.setBackground(new Color(252, 171, 171));
            }
            case 4 -> {
                ProductsPane2ProductPrice.requestFocus();
                ProductsPane2ProductPrice.setBackground(new Color(252, 171, 171));
            }
            case 5 -> {
                panelProducts.setSelectedIndex(2);//change to productline tab
            }

            case 6 -> {
                panelProducts.setSelectedIndex(3);//change to items tab
            }
        }
    }//GEN-LAST:event_ProductsPane2BtnAddActionPerformed

    private void ProductsPane2AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane2AddItemActionPerformed
        try {
            var cProduct = new ControlProducts();
            cProduct.btnAddItem();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_ProductsPane2AddItemActionPerformed

    private void ProductsPane3BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane3BtnAddActionPerformed
        ControlProductLine cpLine = new ControlProductLine();
        cpLine.addLine();
    }//GEN-LAST:event_ProductsPane3BtnAddActionPerformed

    private void ProductsPane3BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane3BtnSaveActionPerformed
        ControlProductLine cpLine = new ControlProductLine();
        cpLine.saveLine();
    }//GEN-LAST:event_ProductsPane3BtnSaveActionPerformed

    private void ProductsPane2BtnRemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane2BtnRemoveItemActionPerformed
        try {
            if (!(ProductsPane2Item.getSelectedIndex() == 0 && ProductsPane2ItemList.isSelectionEmpty())) {
                var cProduct = new ControlProducts();
                cProduct.btnRemoveItem();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_ProductsPane2BtnRemoveItemActionPerformed

    private void SuppliersPane2TxtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuppliersPane2TxtQuantityKeyTyped
        SuppliersPane2TxtQuantity.setBackground(Color.white);
    }//GEN-LAST:event_SuppliersPane2TxtQuantityKeyTyped

    private void SuppliersPane2TxtTotalCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuppliersPane2TxtTotalCostKeyTyped
        SuppliersPane2TxtTotalCost.setBackground(Color.white);
    }//GEN-LAST:event_SuppliersPane2TxtTotalCostKeyTyped

    private void SuppliersPane2BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersPane2BtnClearActionPerformed
        ControlSuppliersItems csItems = new ControlSuppliersItems();
        csItems.ClearItemPurchase();
        csItems.loadItemPurchased();
    }//GEN-LAST:event_SuppliersPane2BtnClearActionPerformed

    private void SuppliersBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersBtnSearchActionPerformed
        if (panelPurchases.isShowing()) {
            ControlSuppliersItems csItems = new ControlSuppliersItems();
            csItems.searchItemPurchased();
        } else {
            ControlSuppliersInfo csInfo = new ControlSuppliersInfo();
            csInfo.searchSupplier();
        }
    }//GEN-LAST:event_SuppliersBtnSearchActionPerformed

    private void SuppliersPane2TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuppliersPane2TableMouseClicked
        try {
            ControlSuppliersItems csItems = new ControlSuppliersItems();
            csItems.mouseClickedItemPurchasedTable();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_SuppliersPane2TableMouseClicked

    private void SuppliersPane1BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersPane1BtnDeleteActionPerformed
        ControlSuppliersInfo csInfo = new ControlSuppliersInfo();
        csInfo.deleteSupplier();
    }//GEN-LAST:event_SuppliersPane1BtnDeleteActionPerformed

    private void SuppliersPane1TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuppliersPane1TableMouseClicked
        try {
            ControlSuppliersInfo csInfo = new ControlSuppliersInfo();
            csInfo.mouseClickedSuppliersTable();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_SuppliersPane1TableMouseClicked

    private void SuppliersPane1TxtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuppliersPane1TxtNameKeyTyped
        SuppliersPane1TxtName.setBackground(Color.white);
    }//GEN-LAST:event_SuppliersPane1TxtNameKeyTyped

    private void SuppliersPane1TxtDocumentNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuppliersPane1TxtDocumentNumberKeyTyped
        SuppliersPane1TxtDocumentNumber.setBackground(Color.white);
    }//GEN-LAST:event_SuppliersPane1TxtDocumentNumberKeyTyped

    private void SuppliersPane1TxtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuppliersPane1TxtPhoneKeyTyped
        SuppliersPane1TxtPhone.setBackground(Color.white);
    }//GEN-LAST:event_SuppliersPane1TxtPhoneKeyTyped

    private void ProductsPane4BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane4BtnDeleteActionPerformed
        ControlProductsItems cpItems = new ControlProductsItems();
        cpItems.deleteItem();
    }//GEN-LAST:event_ProductsPane4BtnDeleteActionPerformed

    private void ProductsPane4TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsPane4TableMouseClicked
        try {
            ControlProductsItems cpItems = new ControlProductsItems();
            cpItems.mouseClickedItemsTable();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_ProductsPane4TableMouseClicked

    private void ProductsPane4BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane4BtnClearActionPerformed
        ControlProductsItems cpItems = new ControlProductsItems();
        cpItems.Clear();
        cpItems.loadItems();
    }//GEN-LAST:event_ProductsPane4BtnClearActionPerformed

    private void ProductsPane3BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane3BtnDeleteActionPerformed
        ControlProductLine cpLine = new ControlProductLine();
        cpLine.deleteLine();
    }//GEN-LAST:event_ProductsPane3BtnDeleteActionPerformed

    private void ProductsPane3BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane3BtnClearActionPerformed
        ControlProductLine cpLine = new ControlProductLine();
        cpLine.Clear();
        cpLine.loadProductLines();
    }//GEN-LAST:event_ProductsPane3BtnClearActionPerformed

    private void ProductsPane3TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsPane3TableMouseClicked
        ControlProductLine cpLine = new ControlProductLine();
        cpLine.mouseClickedItemsTable();
    }//GEN-LAST:event_ProductsPane3TableMouseClicked

    private void SuppliersPane1BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersPane1BtnClearActionPerformed
        ControlSuppliersInfo csInfo = new ControlSuppliersInfo();
        csInfo.Clear();
        csInfo.loadSuppliersTable();
    }//GEN-LAST:event_SuppliersPane1BtnClearActionPerformed

    private void ProductsPane2TxtProductCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductsPane2TxtProductCodeKeyPressed
        ProductsPane2TxtProductCode.setBackground(Color.white);
    }//GEN-LAST:event_ProductsPane2TxtProductCodeKeyPressed

    private void ProductsPane2TxtProductNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductsPane2TxtProductNameKeyPressed
        ProductsPane2TxtProductName.setBackground(Color.white);
    }//GEN-LAST:event_ProductsPane2TxtProductNameKeyPressed

    private void ProductsPane2ProductPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductsPane2ProductPriceKeyPressed
        ProductsPane2ProductPrice.setBackground(Color.white);
    }//GEN-LAST:event_ProductsPane2ProductPriceKeyPressed

    private void ProductsPane2BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane2BtnDeleteActionPerformed
        ControlProducts cProduct = new ControlProducts();
        cProduct.deleteProduct();
    }//GEN-LAST:event_ProductsPane2BtnDeleteActionPerformed

    private void ProductsPane2BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane2BtnClearActionPerformed
        ControlProducts cProduct = new ControlProducts();
        cProduct.Clear();
    }//GEN-LAST:event_ProductsPane2BtnClearActionPerformed

    private void CustomersBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersBtnAddActionPerformed
        ControlCustomers cC = new ControlCustomers();
        switch (cC.addCustomer()) {
            case 1 -> {
                CustomersTxtDocumentId.requestFocus();
                CustomersTxtDocumentId.setBackground(new Color(252, 171, 171));
            }
            case 2 -> {
                CustomersTxtName.requestFocus();
                CustomersTxtName.setBackground(new Color(252, 171, 171));
            }
            case 3 -> {
                CustomersTxtLastname.requestFocus();
                CustomersTxtLastname.setBackground(new Color(252, 171, 171));
            }
        }
    }//GEN-LAST:event_CustomersBtnAddActionPerformed

    private void CustomersBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersBtnSaveActionPerformed
        ControlCustomers cC = new ControlCustomers();
        switch (cC.saveCustomer()) {
            case 'a' -> {
                CustomersTxtDocumentId.requestFocus();
                CustomersTxtDocumentId.setBackground(new Color(252, 171, 171));
            }
            case 'b' -> {
                CustomersTxtName.requestFocus();
                CustomersTxtName.setBackground(new Color(252, 171, 171));
            }
            case 'c' -> {
                CustomersTxtLastname.requestFocus();
                CustomersTxtLastname.setBackground(new Color(252, 171, 171));
            }
        }
    }//GEN-LAST:event_CustomersBtnSaveActionPerformed

    private void CustomersBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersBtnDeleteActionPerformed
        ControlCustomers cC = new ControlCustomers();
        cC.deleteCustomer();
    }//GEN-LAST:event_CustomersBtnDeleteActionPerformed

    private void CustomersBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersBtnClearActionPerformed
        ControlCustomers cC = new ControlCustomers();
        cC.Clear();
    }//GEN-LAST:event_CustomersBtnClearActionPerformed

    private void CustomersBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersBtnSearchActionPerformed
        ControlCustomers cC = new ControlCustomers();
        cC.searchLine();
    }//GEN-LAST:event_CustomersBtnSearchActionPerformed

    private void CustomersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomersTableMouseClicked
        ControlCustomers cC = new ControlCustomers();
        cC.mouseClickedCustomer();
    }//GEN-LAST:event_CustomersTableMouseClicked

    private void CustomersTxtDocumentIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomersTxtDocumentIdKeyTyped
        CustomersTxtDocumentId.setBackground(Color.white);
    }//GEN-LAST:event_CustomersTxtDocumentIdKeyTyped

    private void CustomersTxtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomersTxtNameKeyTyped
        CustomersTxtName.setBackground(Color.white);
    }//GEN-LAST:event_CustomersTxtNameKeyTyped

    private void CustomersTxtLastnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomersTxtLastnameKeyTyped
        CustomersTxtLastname.setBackground(Color.white);
    }//GEN-LAST:event_CustomersTxtLastnameKeyTyped

    private void AdminBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBtnAddActionPerformed
        ControlAdmin ca = new ControlAdmin();
        switch (ca.addAdmin()) {
            case 1 -> {
                AdminTxtName.requestFocus();
                AdminTxtName.setBackground(new Color(252, 171, 171));
            }
            case 2 -> {
                AdminTxtLastname.requestFocus();
                AdminTxtLastname.setBackground(new Color(252, 171, 171));
            }
            case 3 -> {
                AdminTxtEmail.requestFocus();
                AdminTxtEmail.setBackground(new Color(252, 171, 171));
            }
            case 4 -> {
                AdminTxtPhone.requestFocus();
                AdminTxtPhone.setBackground(new Color(252, 171, 171));
            }
        }
    }//GEN-LAST:event_AdminBtnAddActionPerformed

    private void AdminTxtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminTxtNameKeyPressed
        AdminTxtName.setBackground(Color.white);
    }//GEN-LAST:event_AdminTxtNameKeyPressed

    private void AdminTxtLastnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminTxtLastnameKeyPressed
        AdminTxtLastname.setBackground(Color.white);
    }//GEN-LAST:event_AdminTxtLastnameKeyPressed

    private void AdminTxtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminTxtEmailKeyPressed
        AdminTxtEmail.setBackground(Color.white);
    }//GEN-LAST:event_AdminTxtEmailKeyPressed

    private void AdminTxtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdminTxtPhoneKeyPressed
        AdminTxtPhone.setBackground(Color.white);
    }//GEN-LAST:event_AdminTxtPhoneKeyPressed

    private void AdminBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBtnSaveActionPerformed
        ControlAdmin ca = new ControlAdmin();
        ca.updateAdmin();
    }//GEN-LAST:event_AdminBtnSaveActionPerformed

    private void AdminBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBtnDeleteActionPerformed
        ControlAdmin ca = new ControlAdmin();
        ca.deleteAdmin();
    }//GEN-LAST:event_AdminBtnDeleteActionPerformed

    private void AdminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminTableMouseClicked
        ControlAdmin ca = new ControlAdmin();
        ca.mouseClickedAdmin();
    }//GEN-LAST:event_AdminTableMouseClicked

    private void AdminBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBtnSearchActionPerformed
        ControlAdmin ca = new ControlAdmin();
        ca.searchAdmin();
    }//GEN-LAST:event_AdminBtnSearchActionPerformed

    private void AdminBtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBtnClearActionPerformed
        ControlAdmin ca = new ControlAdmin();
        ca.Clear();
    }//GEN-LAST:event_AdminBtnClearActionPerformed

    private void saleBtnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleBtnSearchProductActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnSearchProduct();
    }//GEN-LAST:event_saleBtnSearchProductActionPerformed

    private void saleSearchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleSearchListMouseClicked
        ControlSales cs = new ControlSales();
        cs.mouseClickedSearchList();
    }//GEN-LAST:event_saleSearchListMouseClicked

    private void SaleBtnSearchProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleBtnSearchProduct1ActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnAddProduct();
    }//GEN-LAST:event_SaleBtnSearchProduct1ActionPerformed

    private void SaleBtnDropProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleBtnDropProductActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnRemoveProduct();
    }//GEN-LAST:event_SaleBtnDropProductActionPerformed

    private void SaleProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaleProductListMouseClicked
        ControlSales cs = new ControlSales();
        cs.mouseClickedProductList();
    }//GEN-LAST:event_SaleProductListMouseClicked

    private void ProductsPane2ItemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsPane2ItemListMouseClicked
        ControlProducts cp = new ControlProducts();
        cp.mouseClickedProductList();
    }//GEN-LAST:event_ProductsPane2ItemListMouseClicked

    private void SaleTxtPricePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_SaleTxtPricePropertyChange
        ControlSales cs = new ControlSales();
        cs.directFinalPrice();
    }//GEN-LAST:event_SaleTxtPricePropertyChange

    private void SaleTxtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SaleTxtDiscountKeyReleased
        ControlSales cs = new ControlSales();
        cs.discountFinalPrice();
    }//GEN-LAST:event_SaleTxtDiscountKeyReleased

    private void SaleDiscountTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SaleDiscountTypeItemStateChanged
        ControlSales cs = new ControlSales();
        cs.discountFinalPrice();
    }//GEN-LAST:event_SaleDiscountTypeItemStateChanged

    private void SaleBtnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleBtnSearchCustomerActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnSearchCustomer();
    }//GEN-LAST:event_SaleBtnSearchCustomerActionPerformed

    private void SaleBtnClearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleBtnClearCustomerActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnClearCustomer();
    }//GEN-LAST:event_SaleBtnClearCustomerActionPerformed

    private void SaleBtnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleBtnClearAllActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnClearAll();
    }//GEN-LAST:event_SaleBtnClearAllActionPerformed

    private void productPane5BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPane5BtnSearchActionPerformed
        ControlProductStock cps = new ControlProductStock();
        cps.btnSearchName();
    }//GEN-LAST:event_productPane5BtnSearchActionPerformed

    private void ProductsPane5SearchListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsPane5SearchListMouseClicked
        ControlProductStock cps = new ControlProductStock();
        cps.mouseClickedList();
    }//GEN-LAST:event_ProductsPane5SearchListMouseClicked

    private void ProductsPane5BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane5BtnAddActionPerformed
        ControlProductStock cps = new ControlProductStock();
        cps.btnAddStock();
    }//GEN-LAST:event_ProductsPane5BtnAddActionPerformed

    private void ProductsPane5BtnReleaseItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane5BtnReleaseItemsActionPerformed
        ControlProductStock cps = new ControlProductStock();
        cps.btnReleaseStock();
    }//GEN-LAST:event_ProductsPane5BtnReleaseItemsActionPerformed

    private void ProductsPane5BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductsPane5BtnClearActionPerformed
        ControlProductStock cps = new ControlProductStock();
        cps.Clear();
    }//GEN-LAST:event_ProductsPane5BtnClearActionPerformed

    private void SaleBtnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleBtnPayActionPerformed
        ControlSales cs = new ControlSales();
        cs.btnPay();
    }//GEN-LAST:event_SaleBtnPayActionPerformed

    private void ProductsPane5TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductsPane5TableMouseClicked
        ControlProductStock cps = new ControlProductStock();
        cps.mouseClickedTable();
    }//GEN-LAST:event_ProductsPane5TableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ControlReports cr = new ControlReports();
        cr.search();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ControlReports cr = new ControlReports();
        cr.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminBtnAdd;
    private javax.swing.JButton AdminBtnClear;
    private javax.swing.JButton AdminBtnDelete;
    private javax.swing.JButton AdminBtnSave;
    private javax.swing.JButton AdminBtnSearch;
    private static javax.swing.JComboBox<String> AdminJobTitleList;
    private static javax.swing.JTable AdminTable;
    private static javax.swing.JTextField AdminTxtEmail;
    private static javax.swing.JTextField AdminTxtLastname;
    private static javax.swing.JTextField AdminTxtName;
    private static javax.swing.JTextField AdminTxtPhone;
    private static javax.swing.JTextField AdminTxtSearch;
    private javax.swing.JButton CustomersBtnAdd;
    private javax.swing.JButton CustomersBtnClear;
    private javax.swing.JButton CustomersBtnDelete;
    private javax.swing.JButton CustomersBtnSave;
    private javax.swing.JButton CustomersBtnSearch;
    private static javax.swing.JTable CustomersTable;
    private static javax.swing.JTextField CustomersTxtDocumentId;
    private static javax.swing.JTextField CustomersTxtEmail;
    private static javax.swing.JTextField CustomersTxtLastname;
    private static javax.swing.JTextField CustomersTxtName;
    private static javax.swing.JTextField CustomersTxtPhone;
    private static javax.swing.JTextField CustomersTxtSearch;
    private javax.swing.JPanel ItemsPanel;
    private javax.swing.JPanel ProductDetailsPanel;
    private javax.swing.JPanel ProductLinesPanel;
    private javax.swing.JButton ProductsBtnSearch;
    private javax.swing.JButton ProductsPane2AddItem;
    private javax.swing.JButton ProductsPane2BtnAdd;
    private javax.swing.JButton ProductsPane2BtnClear;
    private javax.swing.JButton ProductsPane2BtnDelete;
    private javax.swing.JButton ProductsPane2BtnRemoveItem;
    private static javax.swing.JComboBox<String> ProductsPane2Item;
    private static javax.swing.JList<String> ProductsPane2ItemList;
    private static javax.swing.JComboBox<String> ProductsPane2ProductLine;
    private static javax.swing.JTextField ProductsPane2ProductPrice;
    private static javax.swing.JTable ProductsPane2Table;
    private static javax.swing.JTextField ProductsPane2TxtProductCode;
    private static javax.swing.JTextField ProductsPane2TxtProductName;
    private javax.swing.JButton ProductsPane3BtnAdd;
    private javax.swing.JButton ProductsPane3BtnClear;
    private javax.swing.JButton ProductsPane3BtnDelete;
    private javax.swing.JButton ProductsPane3BtnSave;
    private static javax.swing.JTable ProductsPane3Table;
    private static javax.swing.JTextField ProductsPane3TxtProductLineName;
    private javax.swing.JButton ProductsPane4BtnAdd;
    private javax.swing.JButton ProductsPane4BtnClear;
    private javax.swing.JButton ProductsPane4BtnDelete;
    private javax.swing.JButton ProductsPane4BtnSave;
    private static javax.swing.JComboBox<String> ProductsPane4ItemMeasureType;
    private static javax.swing.JTable ProductsPane4Table;
    private static javax.swing.JTextField ProductsPane4TxtItemName;
    private javax.swing.JButton ProductsPane5BtnAdd;
    private javax.swing.JButton ProductsPane5BtnClear;
    private javax.swing.JButton ProductsPane5BtnReleaseItems;
    private static javax.swing.JComboBox<String> ProductsPane5CBoxProduct;
    private static javax.swing.JList<String> ProductsPane5SearchList;
    private static javax.swing.JTable ProductsPane5Table;
    private static javax.swing.JTextField ProductsPane5TxtProduct;
    private static javax.swing.JTextField ProductsPane5TxtQty;
    private javax.swing.JPanel ProductsStockPanel;
    private javax.swing.JPanel ProductsTablePanel;
    private static javax.swing.JTextField ProductsTxtSearch;
    private static com.toedter.calendar.JDateChooser ReportsFromDate;
    private static javax.swing.JComboBox<String> ReportsPurchasesOrSales;
    private static javax.swing.JTable ReportsTable;
    private static com.toedter.calendar.JDateChooser ReportsToDate;
    private javax.swing.JButton SaleBtnClearAll;
    private javax.swing.JButton SaleBtnClearCustomer;
    private javax.swing.JButton SaleBtnDropProduct;
    private javax.swing.JButton SaleBtnPay;
    private javax.swing.JButton SaleBtnSearchCustomer;
    private javax.swing.JButton SaleBtnSearchProduct1;
    private static javax.swing.JComboBox<String> SaleDiscountType;
    private static javax.swing.JComboBox<String> SaleProductCBox;
    private static javax.swing.JList<String> SaleProductList;
    private static javax.swing.JTable SaleTableProduct;
    private static javax.swing.JTextField SaleTxtCustomerId;
    private static javax.swing.JLabel SaleTxtCustomerName;
    private static javax.swing.JTextField SaleTxtCustomerPay;
    private static javax.swing.JTextField SaleTxtDiscount;
    private static javax.swing.JLabel SaleTxtEmployeeID;
    private static javax.swing.JLabel SaleTxtEmployeeName;
    private static javax.swing.JLabel SaleTxtPrice;
    private static javax.swing.JLabel SaleTxtTotalCost;
    private javax.swing.JButton SuppliersBtnSearch;
    private javax.swing.JButton SuppliersPane1BtnAdd;
    private javax.swing.JButton SuppliersPane1BtnClear;
    private javax.swing.JButton SuppliersPane1BtnDelete;
    private javax.swing.JButton SuppliersPane1BtnSave;
    private static javax.swing.JComboBox<String> SuppliersPane1DocumentType;
    private static javax.swing.JTable SuppliersPane1Table;
    private static javax.swing.JTextField SuppliersPane1TxtDocumentNumber;
    private static javax.swing.JTextField SuppliersPane1TxtName;
    private static javax.swing.JTextField SuppliersPane1TxtPhone;
    private javax.swing.JButton SuppliersPane2BtnBuy;
    private javax.swing.JButton SuppliersPane2BtnClear;
    private static javax.swing.JComboBox<String> SuppliersPane2ItemList;
    private static javax.swing.JComboBox<String> SuppliersPane2SupplierList;
    private static javax.swing.JTable SuppliersPane2Table;
    private static javax.swing.JTextField SuppliersPane2TxtQuantity;
    private static javax.swing.JTextField SuppliersPane2TxtTotalCost;
    private static javax.swing.JTextField SuppliersTxtSearch;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private static javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private static javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private static javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblCustomerPay;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDollar;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblProduct1;
    private javax.swing.JLabel lblProduct2;
    private javax.swing.JLabel lblProduct3;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JLabel lblSaleDetails;
    private javax.swing.JLabel lblTittleSales;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JPanel panelProductDetailsOperation;
    private javax.swing.JPanel panelProductLines;
    private javax.swing.JTabbedPane panelProducts;
    private javax.swing.JPanel panelProductsItemDetails;
    private javax.swing.JPanel panelProductsTittle;
    private javax.swing.JPanel panelPurchases;
    private javax.swing.JPanel panelSaleCustomer;
    private javax.swing.JPanel panelSaleOperation;
    private javax.swing.JPanel panelSalesInfo;
    private javax.swing.JPanel panelSalesTable;
    private javax.swing.JPanel panelSalesTittle;
    private javax.swing.JPanel panelSupplierInfo;
    private javax.swing.JTabbedPane panelSuppliersMain;
    private javax.swing.JPanel panelSuppliersOperations1;
    private javax.swing.JPanel panelSuppliersOperations2;
    private javax.swing.JPanel panelSuppliersOperations3;
    private javax.swing.JPanel panelSuppliersTitle;
    private javax.swing.JPanel panelTableItems;
    private static javax.swing.JPanel panelTableProductDetails;
    private javax.swing.JPanel panelTableProductLines;
    private javax.swing.JButton productPane5BtnSearch;
    private javax.swing.JPanel productPanel;
    private javax.swing.JPanel reportsPanel;
    private javax.swing.JButton saleBtnSearchProduct;
    private javax.swing.JPanel salePanel;
    private static javax.swing.JList<String> saleSearchList;
    private static javax.swing.JTextField saleTxtProduct;
    private static javax.swing.JSpinner saleTxtQty;
    private javax.swing.JPanel subPanelReports;
    private javax.swing.JPanel supplierPanel;
    private javax.swing.JPanel tablePanelCustomers;
    private javax.swing.JPanel tablePanelSuppliers1;
    private javax.swing.JPanel tablePanelSuppliers2;
    // End of variables declaration//GEN-END:variables

    public static JTable getAdminTable() {
        return AdminTable;
    }

    public static void setAdminTable(JTable AdminTable) {
        ViewMain.AdminTable = AdminTable;
    }

    public static JTextField getAdminTxtEmail() {
        return AdminTxtEmail;
    }

    public static void setAdminTxtEmail(String AdminTxtEmail) {
        ViewMain.AdminTxtEmail.setText(AdminTxtEmail);
    }

    public static JTextField getAdminTxtLastname() {
        return AdminTxtLastname;
    }

    public static void setAdminTxtLastname(String AdminTxtLastname) {
        ViewMain.AdminTxtLastname.setText(AdminTxtLastname);
    }

    public static JTextField getAdminTxtName() {
        return AdminTxtName;
    }

    public static void setAdminTxtName(String AdminTxtName) {
        ViewMain.AdminTxtName.setText(AdminTxtName);
    }

    public static JTextField getAdminTxtPhone() {
        return AdminTxtPhone;
    }

    public static void setAdminTxtPhone(String AdminTxtPhone) {
        ViewMain.AdminTxtPhone.setText(AdminTxtPhone);
    }

    public static JComboBox<String> getAdminJobTitleList() {
        return AdminJobTitleList;
    }

    public static void setAdminJobTitleList(JComboBox<String> AdminJobTitleList) {
        ViewMain.AdminJobTitleList = AdminJobTitleList;
    }

    public static JTextField getAdminTxtSearch() {
        return AdminTxtSearch;
    }

    public static void setAdminTxtSearch(String AdminTxtSearch) {
        ViewMain.AdminTxtSearch.setText(AdminTxtSearch);
    }

    public static JTable getCustomersTable() {
        return CustomersTable;
    }

    public static void setCustomersTable(JTable CustomersTable) {
        ViewMain.CustomersTable = CustomersTable;
    }

    public static JTextField getCustomersTxtSearch() {
        return CustomersTxtSearch;
    }

    public static void setCustomersTxtSearch(String CustomersTxtSearch) {
        ViewMain.CustomersTxtSearch.setText(CustomersTxtSearch);
    }

    public static JTextField getCustomersTxtDocumentId() {
        return CustomersTxtDocumentId;
    }

    public static void setCustomersTxtDocumentId(String CustomersTxtDocumentId) {
        ViewMain.CustomersTxtDocumentId.setText(CustomersTxtDocumentId);
    }

    public static JTextField getCustomersTxtEmail() {
        return CustomersTxtEmail;
    }

    public static void setCustomersTxtEmail(String CustomersTxtEmail) {
        ViewMain.CustomersTxtEmail.setText(CustomersTxtEmail);
    }

    public static JTextField getCustomersTxtLastname() {
        return CustomersTxtLastname;
    }

    public static void setCustomersTxtLastname(String CustomersTxtLastname) {
        ViewMain.CustomersTxtLastname.setText(CustomersTxtLastname);
    }

    public static JTextField getCustomersTxtName() {
        return CustomersTxtName;
    }

    public static void setCustomersTxtName(String CustomersTxtName) {
        ViewMain.CustomersTxtName.setText(CustomersTxtName);
    }

    public static JTextField getCustomersTxtPhone() {
        return CustomersTxtPhone;
    }

    public static void setCustomersTxtPhone(String CustomersTxtPhone) {
        ViewMain.CustomersTxtPhone.setText(CustomersTxtPhone);
    }

    public static JTextField getProductsTxtSearch() {
        return ProductsTxtSearch;
    }

    public static void setProductsTxtSearch(String ProductsTxtSearch) {
        ViewMain.ProductsTxtSearch.setText(ProductsTxtSearch);
    }

    public static JComboBox<String> getProductsPane2Item() {
        return ProductsPane2Item;
    }

    public static void setProductsPane2ItemList(JList list) {
        ViewMain.ProductsPane2ItemList = list;
    }

    public static JList getProductsPane2ItemList() {//AQUI Y ARRIBA DE AQUI PUEDEN ESTAR LOS PROBLEMAS
        return ProductsPane2ItemList;
    }

    public static void setProductsPane2Item(JComboBox<String> ProductsPane2Item) {
        ViewMain.ProductsPane2Item = ProductsPane2Item;
    }

    public static JComboBox<String> getProductsPane2ProductLine() {
        return ProductsPane2ProductLine;
    }

    public static void setProductsPane2ProductLine(JComboBox<String> ProductsPane2ProductLine) {
        ViewMain.ProductsPane2ProductLine = ProductsPane2ProductLine;
    }

    public static JTextField getProductsPane2ProductPrice() {
        return ProductsPane2ProductPrice;
    }

    public static void setProductsPane2ProductPrice(String ProductsPane2ProductPrice) {
        ViewMain.ProductsPane2ProductPrice.setText(ProductsPane2ProductPrice);
    }

    public static JTable getProductsPane2Table() {
        return ProductsPane2Table;
    }

    public static void setProductsPane2Table(JTable ProductsPane2Table) {
        ViewMain.ProductsPane2Table = ProductsPane2Table;
    }

    public static JTextField getProductsPane2TxtProductCode() {
        return ProductsPane2TxtProductCode;
    }

    public static void setProductsPane2TxtProductCode(String ProductsPane2TxtProductCode) {
        ViewMain.ProductsPane2TxtProductCode.setText(ProductsPane2TxtProductCode);
    }

    public static JTextField getProductsPane2TxtProductName() {
        return ProductsPane2TxtProductName;
    }

    public static void setProductsPane2TxtProductName(String ProductsPane2TxtProductName) {
        ViewMain.ProductsPane2TxtProductName.setText(ProductsPane2TxtProductName);
    }

    public static JTable getProductsPane3Table() {
        return ProductsPane3Table;
    }

    public static void setProductsPane3Table(JTable ProductsPane3Table) {
        ViewMain.ProductsPane3Table = ProductsPane3Table;
    }

    public static JTextField getProductsPane3TxtProductLineName() {
        return ProductsPane3TxtProductLineName;
    }

    public static void setProductsPane3TxtProductLineName(String ProductsPane3TxtProductLineName) {
        ViewMain.ProductsPane3TxtProductLineName.setText(ProductsPane3TxtProductLineName);
    }

    public static JComboBox<String> getProductsPane4ItemMeasureType() {
        return ProductsPane4ItemMeasureType;
    }

    public static void setProductsPane4ItemMeasureType(JComboBox<String> ProductsPane4ItemMeasureType) {
        ViewMain.ProductsPane4ItemMeasureType = ProductsPane4ItemMeasureType;
    }

    public static JTable getProductsPane4Table() {
        return ProductsPane4Table;
    }

    public static void setProductsPane4Table(JTable ProductsPane4Table) {
        ViewMain.ProductsPane4Table = ProductsPane4Table;
    }

    public static JTextField getProductsPane4TxtItemName() {
        return ProductsPane4TxtItemName;
    }

    public static void setProductsPane4TxtItemName(String ProductsPane4TxtItemName) {
        ViewMain.ProductsPane4TxtItemName.setText(ProductsPane4TxtItemName);
    }

    public static JTable getProductsPane5Table() {
        return ProductsPane5Table;
    }

    public static void setProductsPane5Table(JTable ProductsPane5Table) {
        ViewMain.ProductsPane5Table = ProductsPane5Table;
    }

    public static JTextField getProductsPane5TxtProduct() {
        return ProductsPane5TxtProduct;
    }

    public static void setProductsPane5TxtProduct(JTextField ProductsPane5TxtProduct) {
        ViewMain.ProductsPane5TxtProduct = ProductsPane5TxtProduct;
    }

    public static JTextField getProductsPane5TxtQty() {
        return ProductsPane5TxtQty;
    }

    public static void setProductsPane5TxtQty(JTextField ProductsPane5TxtQty) {
        ViewMain.ProductsPane5TxtQty = ProductsPane5TxtQty;
    }

    public static JComboBox<String> getProductsPane5CBoxProduct() {
        return ProductsPane5CBoxProduct;
    }

    public static void setProductsPane5CBoxProduct(JComboBox<String> ProductsPane5CBoxProduct) {
        ViewMain.ProductsPane5CBoxProduct = ProductsPane5CBoxProduct;
    }

    public static JList<String> getProductsPane5SearchList() {
        return ProductsPane5SearchList;
    }

    public static void setProductsPane5SearchList(JList<String> ProductsPane5SearchList) {
        ViewMain.ProductsPane5SearchList = ProductsPane5SearchList;
    }
    
    

    public static JComboBox<String> getSaleProductCBox() {
        return SaleProductCBox;
    }

    public static void setSaleProductCBox(JComboBox<String> SaleProduct) {
        ViewMain.SaleProductCBox = SaleProduct;
    }

    public static JLabel getSaleTxtCustomerName() {
        return SaleTxtCustomerName;
    }

    public static void setSaleTxtCustomerName(JLabel SaleTxtCustomerName) {
        ViewMain.SaleTxtCustomerName = SaleTxtCustomerName;
    }

    public static JLabel getSaleTxtEmployeeName() {
        return SaleTxtEmployeeName;
    }

    public static void setSaleTxtEmployeeName(JLabel SaleTxtEmployeeName) {
        ViewMain.SaleTxtEmployeeName = SaleTxtEmployeeName;
    }

    public static JComboBox<String> getSaleDiscountType() { //CHECK IF THIS MAKE ANY PROBLEM
        return SaleDiscountType;
    }

    public static void setSaleDiscountType(JComboBox<String> SaleDiscountType) {
        ViewMain.SaleDiscountType = SaleDiscountType;
    }

    public static JList<String> getSaleProductList() {
        return SaleProductList;
    }

    public static void setSaleProductList(JList<String> SaleProductList) {
        ViewMain.SaleProductList = SaleProductList;
    }

    public static JTable getSaleTableProduct() {
        return SaleTableProduct;
    }

    public static void setSaleTableProduct(JTable SaleTableProduct) {
        ViewMain.SaleTableProduct = SaleTableProduct;
    }
    
    public static JTextField getSaleTxtCustomerId() {
        return SaleTxtCustomerId;
    }

    public static void setSaleTxtCustomerId(String SaleTxtCustomerId) {
        ViewMain.SaleTxtCustomerId.setText(SaleTxtCustomerId);
    }

    public static JTextField getSaleTxtCustomerPay() {
        return SaleTxtCustomerPay;
    }

    public static void setSaleTxtCustomerPay(String SaleTxtCustomerPay) {
        ViewMain.SaleTxtCustomerPay.setText(SaleTxtCustomerPay);
    }

    public static JTextField getSaleTxtDiscount() {
        return SaleTxtDiscount;
    }

    public static void setSaleTxtDiscount(String SaleTxtDiscount) {
        ViewMain.SaleTxtDiscount.setText(SaleTxtDiscount);
    }

    public static JLabel getSaleTxtPrice() {
        return SaleTxtPrice;
    }

    public static void setSaleTxtPrice(String SaleTxtPrice) {
        ViewMain.SaleTxtPrice.setText(SaleTxtPrice);
    }

    public static JLabel getSaleTxtTotalCost() {
        return SaleTxtTotalCost;
    }

    public static void setSaleTxtTotalCost(String SaleTxtTotalCost) {
        ViewMain.SaleTxtTotalCost.setText(SaleTxtTotalCost);
    }

    public static JList<String> getSaleSearchList() {
        return saleSearchList;
    }

    public static void setSaleSearchList(JList<String> saleSearchList) {
        ViewMain.saleSearchList = saleSearchList;
    }

    public static JTextField getSaleTxtProduct() {
        return saleTxtProduct;
    }

    public static void setSaleTxtProduct(JTextField saleTxtProduct) {
        ViewMain.saleTxtProduct = saleTxtProduct;
    }

    public static JSpinner getSaleTxtQty() {
        return saleTxtQty;
    }

    public static void setSaleTxtQty(JSpinner saleTxtQty) {
        ViewMain.saleTxtQty = saleTxtQty;
    }

    public static JComboBox<String> getSuppliersPane1DocumentType() {
        return SuppliersPane1DocumentType;
    }

    public static void setSuppliersPane1DocumentType(JComboBox<String> SuppliersPane1DocumentType) {
        ViewMain.SuppliersPane1DocumentType = SuppliersPane1DocumentType;
    }

    public static JTable getSuppliersPane1Table() {
        return SuppliersPane1Table;
    }

    public static void setSuppliersPane1Table(JTable SuppliersPane1Table) {
        ViewMain.SuppliersPane1Table = SuppliersPane1Table;
    }

    public static JTextField getSuppliersPane1TxtDocumentNumber() {
        return SuppliersPane1TxtDocumentNumber;
    }

    public static void setSuppliersPane1TxtDocumentNumber(String SuppliersPane1TxtDocumentNumber) {
        ViewMain.SuppliersPane1TxtDocumentNumber.setText(SuppliersPane1TxtDocumentNumber);
    }

    public static JTextField getSuppliersPane1TxtName() {
        return SuppliersPane1TxtName;
    }

    public static void setSuppliersPane1TxtName(String SuppliersPane1TxtName) {
        ViewMain.SuppliersPane1TxtName.setText(SuppliersPane1TxtName);
    }

    public static JTextField getSuppliersPane1TxtPhone() {
        return SuppliersPane1TxtPhone;
    }

    public static void setSuppliersPane1TxtPhone(String SuppliersPane1TxtPhone) {
        ViewMain.SuppliersPane1TxtPhone.setText(SuppliersPane1TxtPhone);
    }

    public static JTable getSuppliersPane2Table() {
        return SuppliersPane2Table;
    }

    public static void setSuppliersPane2Table(JTable SuppliersPane2Table) {
        ViewMain.SuppliersPane2Table = SuppliersPane2Table;
    }

    public static JTextField getSuppliersPane2TxtTotalCost() {
        return SuppliersPane2TxtTotalCost;
    }

    public static void setSuppliersPane2TxtTotalCost(String SuppliersPane2TxtPriceEach) {
        ViewMain.SuppliersPane2TxtTotalCost.setText(SuppliersPane2TxtPriceEach);
    }

    public static JTextField getSuppliersPane2TxtQuantity() {
        return SuppliersPane2TxtQuantity;
    }

    public static void setSuppliersPane2TxtQuantity(String SuppliersPane2TxtQuantity) {
        ViewMain.SuppliersPane2TxtQuantity.setText(SuppliersPane2TxtQuantity);
    }

    public static JComboBox<String> getSuppliersPane2SupplierList() {
        return SuppliersPane2SupplierList;
    }

    public static void setSuppliersPane2SupplierList(JComboBox<String> SuppliersPane2SupplierList) {
        ViewMain.SuppliersPane2SupplierList = SuppliersPane2SupplierList;
    }

    public static JComboBox<String> getSuppliersPane2ItemList() {
        return SuppliersPane2ItemList;
    }

    public static void setSuppliersPane2ItemList(JComboBox<String> SuppliersPane2ItemList) {
        ViewMain.SuppliersPane2ItemList = SuppliersPane2ItemList;
    }

    public static JTextField getSuppliersTxtSearch() {
        return SuppliersTxtSearch;
    }

    public static void setSuppliersTxtSearch(String SuppliersTxtSearch) {
        ViewMain.SuppliersTxtSearch.setText(SuppliersTxtSearch);
    }

    public static JScrollPane getjScrollPane9() {
        return jScrollPane9;
    }

    public static void setjScrollPane9(JScrollPane jScrollPane9) {
        ViewMain.jScrollPane9 = jScrollPane9;
    }

    public static JScrollPane getjScrollPane11() {
        return jScrollPane11;
    }

    public static void setjScrollPane11(JScrollPane jScrollPane11) {
        ViewMain.jScrollPane11 = jScrollPane11;
    }

    public static JPanel getPanelTableProductDetails() {
        return panelTableProductDetails;
    }

    public static void setPanelTableProductDetails(JPanel panelTableProductDetails) {
        ViewMain.panelTableProductDetails = panelTableProductDetails;
    }

    public static JLabel getSaleTxtEmployeeID() {
        return SaleTxtEmployeeID;
    }

    public static void setSaleTxtEmployeeID(JLabel SaleTxtEmployeeID) {
        ViewMain.SaleTxtEmployeeID = SaleTxtEmployeeID;
    }

    public static JScrollPane getjScrollPane13() {
        return jScrollPane13;
    }

    public static void setjScrollPane13(JScrollPane jScrollPane13) {
        ViewMain.jScrollPane13 = jScrollPane13;
    }

    public static JDateChooser getReportsFromDate() {
        return ReportsFromDate;
    }

    public static void setReportsFromDate(JDateChooser ReportsFromDate) {
        ViewMain.ReportsFromDate = ReportsFromDate;
    }

    public static JComboBox<String> getReportsPurchasesOrSales() {
        return ReportsPurchasesOrSales;
    }

    public static void setReportsPurchasesOrSales(JComboBox<String> ReportsPurchasesOrSales) {
        ViewMain.ReportsPurchasesOrSales = ReportsPurchasesOrSales;
    }

    public static JTable getReportsTable() {
        return ReportsTable;
    }

    public static void setReportsTable(JTable ReportsTable) {
        ViewMain.ReportsTable = ReportsTable;
    }

    public static JDateChooser getReportsToDate() {
        return ReportsToDate;
    }

    public static void setReportsToDate(JDateChooser ReportsToDate) {
        ViewMain.ReportsToDate = ReportsToDate;
    }
    
    

}
