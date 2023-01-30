package model;

public class Item {

    private String name;
    private String unit;
    private int id;

    public Item() {
    }

    public Item(String name, String unit, int id) {
        this.name = name;
        this.unit = unit;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", unit=" + unit + ", id=" + id + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
