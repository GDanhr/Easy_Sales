package view;

import controller.ControlRegister;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewRegister extends javax.swing.JFrame {

    public ViewRegister() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Register");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitleSign = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        txtConfPass = new javax.swing.JPasswordField();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");
        setResizable(false);

        txtTitleSign.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtTitleSign.setText("Sign in");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name:");

        lblLastName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLastName.setText("Lastname:");

        lblUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUserName.setText("User Name:");

        lblPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Confirm Password:");

        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastNameKeyTyped(evt);
            }
        });

        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameKeyTyped(evt);
            }
        });

        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        txtConfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfPassKeyTyped(evt);
            }
        });

        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setText("Log In");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblUserName)
                    .addComponent(lblLastName)
                    .addComponent(lblName)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtConfPass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(txtTitleSign))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtTitleSign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        ControlRegister cr = new ControlRegister();
        ControlRegister cr2 = new ControlRegister();
        switch (cr.CheckFields()) {
            case 1 -> {
                txtName.requestFocus();
                txtName.setBackground(new Color(252, 171, 171));
            }

            case 2 -> {
                txtLastName.requestFocus();
                txtLastName.setBackground(new Color(252, 171, 171));
            }
            case 3 -> {
                txtPassword.requestFocus();
                txtPassword.setBackground(new Color(252, 171, 171));
            }
            case 4 -> {
                txtConfPass.requestFocus();
                txtConfPass.setBackground(new Color(252, 171, 171));
            }
            case 5 -> {
                txtUserName.requestFocus();
                txtUserName.setBackground(new Color(252, 171, 171));
            }
            case 6 -> {
                switch (cr2.btnRegister()) {
                    case 11 -> {
                        txtPassword.requestFocus();
                        txtConfPass.requestFocus();
                        txtPassword.setBackground(new Color(252, 171, 171));
                        txtConfPass.setBackground(new Color(252, 171, 171));
                    }
                    case 10 -> {
                        txtUserName.requestFocus();
                        txtUserName.setBackground(new Color(252, 171, 171));
                    }

                }
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        txtName.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyTyped
        txtLastName.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txtLastNameKeyTyped

    private void txtUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyTyped
        txtUserName.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txtUserNameKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        txtPassword.setBackground(new Color(255, 255, 255));
        txtConfPass.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtConfPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfPassKeyTyped
        txtConfPass.setBackground(new Color(255, 255, 255));
        txtPassword.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txtConfPassKeyTyped

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        ControlRegister.btnBack();
    }//GEN-LAST:event_BackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private static javax.swing.JPasswordField txtConfPass;
    private static javax.swing.JTextField txtLastName;
    private static javax.swing.JTextField txtName;
    private static javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtTitleSign;
    private static javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    public static JPasswordField getTxtConfPass() {
        return txtConfPass;
    }

    public static void setTxtConfPass(String txtConfPass) {
        ViewRegister.txtConfPass.setText(txtConfPass);
    }

    public static JTextField getTxtLastName() {
        return txtLastName;
    }

    public static void setTxtLastName(String txtLastName) {
        ViewRegister.txtLastName.setText(txtLastName);
    }

    public static JTextField getTxtName() {
        return txtName;
    }

    public static void setTxtName(String txtName) {
        ViewRegister.txtName.setText(txtName);
    }

    public static JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public static void setTxtPassword(String txtPassword) {
        ViewRegister.txtPassword.setText(txtPassword);
    }

    public static JTextField getTxtUserName() {
        return txtUserName;
    }

    public static void setTxtUserName(String txtUserName) {
        ViewRegister.txtUserName.setText(txtUserName);
    }

}
