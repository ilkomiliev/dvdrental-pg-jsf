package dvdrental.pg.jsf.services;

import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.repos.CustomerJpaRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Inject
    private CustomerJpaRepository repository;

    public CustomerService(CustomerJpaRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return repository.findById(id);
    }
}
