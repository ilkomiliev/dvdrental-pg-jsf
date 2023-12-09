package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.DvdRentalPgJsfApplication;
import dvdrental.pg.jsf.entities.Customer;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DvdRentalPgJsfApplication.class)
public class CustomerRepoRealDbTest {

    @Inject
    private CustomerJpaRepository repository;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = repository.getAllCustomers();
        assertThat(customers.size()).isEqualTo(590);
    }
}
