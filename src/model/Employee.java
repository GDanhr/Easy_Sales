package model;

public class Employee {

    private int employee_ID;
    private int employee_Rank;
    private String employee_user;
    private String employee_password;
    private String employee_Name;
    private String employee_Lastname;
    private String employee_Jobtitle;
    private String employee_Email;
    private int employee_phone;

    public Employee() {
    }

    public Employee(int employee_ID, int employee_Rank, String employee_user, String employee_password, String employee_Name, String employee_Lastname, String employee_Jobtitle, String employee_Email, int employee_phone) {
        this.employee_ID = employee_ID;
        this.employee_Rank = employee_Rank;
        this.employee_user = employee_user;
        this.employee_password = employee_password;
        this.employee_Name = employee_Name;
        this.employee_Lastname = employee_Lastname;
        this.employee_Jobtitle = employee_Jobtitle;
        this.employee_Email = employee_Email;
        this.employee_phone = employee_phone;
    }

    @Override
    public String toString() {
        return "Employee{" + "employee_ID=" + employee_ID + ", employee_Rank=" + employee_Rank + ", employee_user=" + employee_user + ", employee_password=" + employee_password + ", employee_Name=" + employee_Name + ", employee_Lastname=" + employee_Lastname + ", employee_Jobtitle=" + employee_Jobtitle + ", employee_Email=" + employee_Email + ", employee_phone=" + employee_phone + '}';
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public int getEmployee_Rank() {
        return employee_Rank;
    }

    public void setEmployee_Rank(int employee_Rank) {
        this.employee_Rank = employee_Rank;
    }

    public String getEmployee_user() {
        return employee_user;
    }

    public void setEmployee_user(String employee_user) {
        this.employee_user = employee_user;
    }

    public String getEmployee_password() {
        return employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }

    public String getEmployee_Name() {
        return employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        this.employee_Name = employee_Name;
    }

    public String getEmployee_Lastname() {
        return employee_Lastname;
    }

    public void setEmployee_Lastname(String employee_Lastname) {
        this.employee_Lastname = employee_Lastname;
    }

    public String getEmployee_Jobtitle() {
        return employee_Jobtitle;
    }

    public void setEmployee_Jobtitle(String employee_Jobtitle) {
        this.employee_Jobtitle = employee_Jobtitle;
    }

    public String getEmployee_Email() {
        return employee_Email;
    }

    public void setEmployee_Email(String employee_Email) {
        this.employee_Email = employee_Email;
    }

    public int getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(int employee_phone) {
        this.employee_phone = employee_phone;
    }

}
