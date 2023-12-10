package dvdrental.pg.jsf.view;

import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.services.CustomerService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public class CustomerViewLazyDataModel extends LazyDataModel<Customer> {

    private CustomerService customerService;

    public CustomerViewLazyDataModel(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return customerService.count().intValue();
    }

    @Override
    public List<Customer> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        Sort sort = Sort.sort(Customer.class).by(Customer::getId).ascending();
        return customerService.findAll(offset/pageSize, pageSize, sort);
    }
}
