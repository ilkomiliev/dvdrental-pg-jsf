package dvdrental.pg.jsf.view;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1000, "f230fh0g3", "Bamboo Watch","Accessories",5));
        products.add(new Product(1001, "nvklal433", "Black Watch", "Accessories", 14));
        products.add(new Product(1002, "zz21cz3c1", "Blue Band", "Fitness", 3));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}