package dvdrental.pg.jsf.view;

import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.repos.CustomerJpaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.LazyDataModel;

import java.io.Serializable;

@Named("dtCustomerView")
@ViewScoped
public class CustomerViewBean implements Serializable {

    private LazyDataModel<Customer> model;
    @Inject
    private transient CustomerJpaRepository customerJpaRepository;

    @PostConstruct
    public void init() {
        model = new CustomerViewLazyDataModel(customerJpaRepository);
    }

    public LazyDataModel<Customer> getModel() {
        return model;
    }

    public void setCustomerJpaRepository(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }
}
