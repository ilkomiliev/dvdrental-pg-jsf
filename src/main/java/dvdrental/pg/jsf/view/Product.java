package dvdrental.pg.jsf.view;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String code;
    private String name;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(int id, String code, String name, String category, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}