package dvdrental.pg.jsf.services;

import dvdrental.pg.jsf.DvdRentalPgJsfApplication;
import dvdrental.pg.jsf.entities.Customer;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = DvdRentalPgJsfApplication.class)
@ActiveProfiles("h2")
class CustomerServiceTest {

    @Inject private CustomerService customerService;

    @Test
    void updateCustomerAddress() {
        Customer customer = customerService.updateCustomerAddress(1, 2);
        System.out.println(customer);
        assertThat(customer.getAddress().getId()).isEqualTo(2);
    }
}