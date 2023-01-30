package model;

public class Product {

    private int id;
    private int code;
    private int Qty;
    private String name;
    private float price;
    private String line;
    private String items;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", Qty=" + Qty + ", name=" + name + ", price=" + price + ", line=" + line + ", items=" + items + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

}
