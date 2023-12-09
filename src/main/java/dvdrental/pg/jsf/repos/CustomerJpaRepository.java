package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Customer;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerJpaRepository extends JpaRepository<Customer, Integer>, CustomCustomerRepository {

}
