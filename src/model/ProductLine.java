package model;

public class ProductLine {

    int productLine_Id;
    String productLine_Name;

    public ProductLine() {
    }
    public ProductLine(int productLine_Id, String productLine_Name) {
        this.productLine_Id = productLine_Id;
        this.productLine_Name = productLine_Name;
    }
    @Override
    public String toString() {
        return "ProductLine{" + "productLine_Id=" + productLine_Id + ", productLine_Name=" + productLine_Name + '}';
    }
    public int getProductLine_Id() {
        return productLine_Id;
    }
    public void setProductLine_Id(int productLine_Id) {
        this.productLine_Id = productLine_Id;
    }
    public String getProductLine_Name() {
        return productLine_Name;
    }
    public void setProductLine_Name(String productLine_Name) {
        this.productLine_Name = productLine_Name;
    }
}
