package model;

public class PurchaseItem {

    private String name;
    private String supplier;
    private int qty;
    private float total_cost;
    private int id;

    public PurchaseItem() {
    }

    public PurchaseItem(String name, String supplier, int qty, float total_cost, int id) {
        this.name = name;
        this.supplier = supplier;
        this.qty = qty;
        this.total_cost = total_cost;
        this.id = id;
    }

    @Override
    public String toString() {
        return "PurchaseItem{" + "name=" + name + ", supplier=" + supplier + ", qty=" + qty + ", total_cost=" + total_cost + ", id=" + id + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
