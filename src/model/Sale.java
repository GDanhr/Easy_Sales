package model;

public class Sale {

    int id;
    String products;
    float cost;
    float final_cost;
    String discount;
    int customer;
    int employee;

    public Sale() {
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", products=" + products + ", cost=" + cost + ", final_cost=" + final_cost + ", discount=" + discount + ", customer=" + customer + ", employee=" + employee + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getFinal_cost() {
        return final_cost;
    }

    public void setFinal_cost(float final_cost) {
        this.final_cost = final_cost;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }
}
