package controller;

import view.ViewLogin;
import model.Employee;
import javax.swing.JOptionPane;
import model.DB;
import view.ViewMain;

public class ControlLogin {

    public static ViewLogin window = new ViewLogin();

    public static void show() {
        window.setVisible(true);
    }

    public static void hide() {
        window.setVisible(false);
    }

    private String user = view.ViewLogin.getTxtUserName().getText().trim();
    private String pass = new String(view.ViewLogin.getTxtPassword().getPassword());
    DB esql = new DB();

    public byte btnLogin() {
        if (!user.equals("") && !pass.equals("")) {
            Employee e = new Employee();
            String newPass = Hash.sha1(pass);
            e.setEmployee_user(user);
            e.setEmployee_password(newPass);

            if (esql.login(e)) {
                ViewMain vm = new ViewMain(e);
                vm.setVisible(true);
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "The user name or password is incorrect.", "Error", JOptionPane.PLAIN_MESSAGE);
                System.out.println(newPass);
                return 2;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter your user name and password.", "Error", JOptionPane.PLAIN_MESSAGE);
            return 2;
        }
    }

    public static void btnSignUp() {
        view.ViewLogin.setTxtUserName("");
        view.ViewLogin.setTxtPassword("");
        ControlLogin.hide();
        ControlRegister.show();
    }

}
