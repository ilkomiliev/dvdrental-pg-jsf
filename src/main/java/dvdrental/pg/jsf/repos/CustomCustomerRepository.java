package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Customer;

import java.util.List;


interface CustomCustomerRepository {

    List<Customer> getAllCustomers();
}
