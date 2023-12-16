package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> result = this.em.createNamedQuery("findAllCustomersNative").getResultList();
        return result;
    }
}
