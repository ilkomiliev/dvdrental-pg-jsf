package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Integer>, CustomCustomerRepository {

}
