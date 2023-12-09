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
        assertThat(customers).hasSize(6);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> allCustomers = repository.getAllCustomers();
        assertThat(allCustomers).hasSize(6);
        for (Customer customer : allCustomers) {
            System.out.println(customer);
        }
    }
}
