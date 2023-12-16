package dvdrental.pg.jsf.view;

import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.repos.CustomerJpaRepository;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public class CustomerViewLazyDataModel extends LazyDataModel<Customer> {

    private CustomerJpaRepository customerJpaRepository;

    public CustomerViewLazyDataModel(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        // seems that the ListDataModel in JakartaEE specifies rowCount from type int !!!
        // see https://jakarta.ee/specifications/faces/4.0/apidocs/jakarta/faces/model/listdatamodel
        return (int) customerJpaRepository.count();
    }

    @Override
    public List<Customer> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        Sort sort = Sort.sort(Customer.class).by(Customer::getId).ascending();
        return customerJpaRepository
                .findAll(
                        PageRequest.of(offset/pageSize, pageSize, sort))
                .stream()
                .toList();
    }
}
