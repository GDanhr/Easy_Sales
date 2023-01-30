package controller;

import model.Employee;
import view.ViewRegister;
import javax.swing.JOptionPane;
import model.DB;

public class ControlRegister 
{

    public static ViewRegister window = new ViewRegister();

    public static void show() {window.setVisible(true);}

    public static void hide() {window.setVisible(false);}
    

    private String name = view.ViewRegister.getTxtName().getText().trim();
    private String lastname = view.ViewRegister.getTxtLastName().getText().trim();
    private String pass = new String(view.ViewRegister.getTxtPassword().getPassword());
    private String conpass = new String(view.ViewRegister.getTxtConfPass().getPassword());
    private String user = view.ViewRegister.getTxtUserName().getText().trim();
    DB esql = new DB();

    public byte CheckFields() 
    {
        
        if (name.equals("")&&lastname.equals("")&&pass.equals("")&&conpass.equals("")&&user.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please, fill in all the fields", "Error", JOptionPane.PLAIN_MESSAGE);
            return 0;
        } 
        else if (name.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Empty name field", "Error", JOptionPane.PLAIN_MESSAGE);
            return 1;
        } 
        else if (lastname.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Empty lastname field", "Error", JOptionPane.PLAIN_MESSAGE);
            return 2;
        } 
        else if (pass.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Empty password field", "Error", JOptionPane.PLAIN_MESSAGE);
            return 3;
        } 
        else if (conpass.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Confirm your password", "Error", JOptionPane.PLAIN_MESSAGE);
            return 4;
        } 
        else if (user.equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Empty UserName", "Error", JOptionPane.PLAIN_MESSAGE);
            return 5;
        } 
        else if(!(name.equals("") && lastname.equals("") && pass.equals("") && conpass.equals("") && user.equals("")))
        {
            return 6;
        }
        else
        {
            return 7;
        }
    }
    public byte btnRegister() 
        {
            Employee e = new Employee();
            int rank = 2;
            if (pass.equals(conpass)) 
            {
                if(esql.newUser(user))
                {
                    String newPass = Hash.sha1(pass);

                    e.setEmployee_user(user);
                    e.setEmployee_password(newPass);
                    e.setEmployee_Name(name);
                    e.setEmployee_Lastname(lastname);
                    e.setEmployee_Rank(rank);
                    e.setEmployee_Jobtitle("Seller");
                    e.setEmployee_phone(0);

                    if (esql.registerUser(e)) 
                    {
                        JOptionPane.showMessageDialog(null, "Successfully registered");
                        btnBack();
                        return 8;
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Register failed", "Error", JOptionPane.PLAIN_MESSAGE);
                        return 9;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Username already exist, try another one", "Error", JOptionPane.PLAIN_MESSAGE);
                    return 10;
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Passwords must match", "Error", JOptionPane.PLAIN_MESSAGE);
                return 11;
            }
        }
    
    public static void btnBack(){
        Clear();
        ControlRegister.hide();
        ControlLogin.show();
    }
        

    private static void Clear() 
    {
        view.ViewRegister.setTxtName("");
        view.ViewRegister.setTxtLastName("");
        view.ViewRegister.setTxtUserName("");
        view.ViewRegister.setTxtPassword("");
        view.ViewRegister.setTxtConfPass("");
    }
    
}
