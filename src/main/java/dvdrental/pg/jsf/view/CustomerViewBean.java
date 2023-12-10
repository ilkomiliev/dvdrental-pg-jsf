package dvdrental.pg.jsf.view;

import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.repos.CustomerJpaRepository;
import dvdrental.pg.jsf.services.CustomerService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.LazyDataModel;

import java.io.Serializable;
import java.util.List;

@Named("dtCustomerView")
@ViewScoped
public class CustomerViewBean implements Serializable {

    private LazyDataModel<Customer> model;
    @Inject
    private transient CustomerService service;

    @PostConstruct
    public void init() {
        model = new CustomerViewLazyDataModel(service);
    }

    public LazyDataModel<Customer> getModel() {
        return model;
    }

    public void setService(CustomerService service) {
        this.service = service;
    }
}
