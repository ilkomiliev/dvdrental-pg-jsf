package dvdrental.pg.jsf.services;

import dvdrental.pg.jsf.entities.Address;
import dvdrental.pg.jsf.entities.Customer;
import dvdrental.pg.jsf.repos.AddressJpaRepository;
import dvdrental.pg.jsf.repos.CustomerJpaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Inject
    private CustomerJpaRepository customerRepository;
    @Inject
    private AddressJpaRepository addressRepository;

    public CustomerService(CustomerJpaRepository customerRepository, AddressJpaRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Customer updateCustomerAddress(Integer customerId, Integer newAddressId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Address address = addressRepository.findById(newAddressId).orElseThrow();
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
}
