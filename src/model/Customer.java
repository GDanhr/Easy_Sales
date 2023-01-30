package model;

public class Customer {

    private int customer_Id;
    private int customer_Document_Id;
    private String customer_Name;
    private String customer_Lastname;
    private int customer_Phone;
    private String customer_email;

    public Customer() {
    }

    public Customer(int customer_Id, int customer_Document_Id, String customer_Name, String customer_Lastname, int customer_Phone, String customer_email) {
        this.customer_Id = customer_Id;
        this.customer_Document_Id = customer_Document_Id;
        this.customer_Name = customer_Name;
        this.customer_Lastname = customer_Lastname;
        this.customer_Phone = customer_Phone;
        this.customer_email = customer_email;
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_Id=" + customer_Id + ", customer_Document_Id=" + customer_Document_Id + ", customer_Name=" + customer_Name + ", customer_Lastname=" + customer_Lastname + ", customer_Phone=" + customer_Phone + ", customer_email=" + customer_email + '}';
    }

    public int getCustomer_Id() {
        return customer_Id;
    }

    public void setCustomer_Id(int customer_Id) {
        this.customer_Id = customer_Id;
    }

    public int getCustomer_Document_Id() {
        return customer_Document_Id;
    }

    public void setCustomer_Document_Id(int customer_Document_Id) {
        this.customer_Document_Id = customer_Document_Id;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCustomer_Lastname() {
        return customer_Lastname;
    }

    public void setCustomer_Lastname(String customer_Lastname) {
        this.customer_Lastname = customer_Lastname;
    }

    public int getCustomer_Phone() {
        return customer_Phone;
    }

    public void setCustomer_Phone(int customer_Phone) {
        this.customer_Phone = customer_Phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

}
