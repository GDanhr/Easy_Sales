package model;

public class Supplier {

    private int id;
    private String name;
    private int phone;
    private int docNum;
    private String docType;

    public Supplier() {
    }

    public Supplier(int id, String name, int phone, int docNum, String docType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.docNum = docNum;
        this.docType = docType;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", docNum=" + docNum + ", docType=" + docType + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getDocNum() {
        return docNum;
    }

    public void setDocNum(int docNum) {
        this.docNum = docNum;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
    
    

}
