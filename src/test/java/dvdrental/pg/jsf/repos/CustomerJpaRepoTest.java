package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Customer;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("h2")
public class CustomerJpaRepoTest {

    @Inject
    private CustomerJpaRepository repository;

    @Test
    public void testFindById() {
        Optional<Customer> byId = repository.findById(1);
        assertThat(byId).isNotEmpty();
        assertThat(byId.get().getId()).isEqualTo(1);
        assertThat(byId.get().getAddress()).isNotNull();
    }

    @Test
    public void testFindAll() {
        List<Customer> customers = repository.findAll();
        checkCustomersAreFullyInitialized(customers);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = repository.getAllCustomers();
        checkCustomersAreFullyInitialized(customers);
    }

    private void checkCustomersAreFullyInitialized(List<Customer> customers) {
        assertThat(customers).hasSize(6);
        customers.forEach(customer -> {
            System.out.println(customer);
            assertThat(customer.getAddress()).isNotNull();
            assertThat(customer.getAddress().getAddress()).isNotEmpty();
            assertThat(customer.getAddress().getCity()).isNotNull();
            assertThat(customer.getAddress().getCity().getCity()).isNotEmpty();
            assertThat(customer.getAddress().getCity().getCountry()).isNotNull();
            assertThat(customer.getAddress().getCity().getCountry().getCountry()).isNotEmpty();
        });
    }
}
