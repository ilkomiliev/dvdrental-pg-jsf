package dvdrental.pg.jsf.view;

import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.repos.CustomerJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("dtCustomerView")
@ViewScoped
public class CustomerViewBean implements Serializable {

    private List<Customer> customers;
    @Inject
    private transient CustomerJpaRepository service;

    @PostConstruct
    public void init() {
        customers = service.findAll();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setService(CustomerJpaRepository service) {
        this.service = service;
    }
}
