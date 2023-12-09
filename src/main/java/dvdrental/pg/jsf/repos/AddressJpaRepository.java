package dvdrental.pg.jsf.repos;

import dvdrental.pg.jsf.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressJpaRepository extends JpaRepository<Address, Integer> {

}
